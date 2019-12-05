package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.*;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    AccountService accountService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    AdminInfoService adminInfoService;

    @Autowired
    MailService mailService;

    private int exists(long id, List<OrderDetail> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @ResponseBody
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buy(@PathVariable("id") long id, HttpSession session) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(new RESTResponse.Error()
                    .setStatus(HttpStatus.BAD_REQUEST.value())
                    .setMessage("Error")
                    .build(),
                    HttpStatus.BAD_REQUEST);
        }
        List<OrderDetail> cart = new ArrayList<OrderDetail>();
        if (session.getAttribute("cart") == null) {
            cart.add(new OrderDetail(product, product.getPrice()));
            session.setAttribute("cart", cart);
        } else {
            cart = (List<OrderDetail>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new OrderDetail(product, product.getPrice()));
            } else {
                return new ResponseEntity<>(new RESTResponse.Error()
                        .setStatus(HttpStatus.CONFLICT.value())
                        .setMessage("Error")
                        .build(),
                        HttpStatus.CONFLICT);
            }
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(cart)
                .build(),
                HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Object> getCart(HttpSession session) {
        List<OrderDetail> cart = new ArrayList<OrderDetail>();
        if (session.getAttribute("cart") != null) {
            cart = (List<OrderDetail>) session.getAttribute("cart");
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(cart)
                .build(),
                HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/removeFromCart", method = RequestMethod.POST)
    public ResponseEntity<Object> removeFormCart(HttpSession session, int productId, int orderId) {
        double totalPrice = 0;
        if(productId != 0 && orderId == 0){
            if (session.getAttribute("cart") != null) {
                List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
                for (OrderDetail orderDetail : cart
                ) {
                    totalPrice = totalPrice + orderDetail.getCurrentPrice();
                }
                for (OrderDetail orderDetail: cart
                ) {
                    if(orderDetail.getProduct().getId() == productId){
                        cart.remove(orderDetail);
                        totalPrice -= orderDetail.getCurrentPrice();
                        break;
                    }
                }
                session.setAttribute("cart", cart);
            }
        }
        if(productId != 0 && orderId != 0){
            OrderDetail orderDetail = orderDetailRepository.findByProductIdAndOrderId(productId, orderId);
            if(orderDetail != null){
                try{
                    orderDetailRepository.delete(orderDetail.getId());
                }
                catch (Exception ex){

                }
            }
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(new Gson().toJson(totalPrice))
                .build(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirm(HttpSession session, OrderProduct orderProduct,
                          @RequestParam("accountId") long accountId) {
        if (session.getAttribute("cart") != null) {
            CustomerInfo customerInfo = customerInfoService.getCustomerInfoByAccount(accountId);
            List<AdminInfo> adminInfos = adminInfoService.adminInfos();
            if(customerInfo == null){
                return "error";
            }
            List<OrderDetail> cart = new ArrayList<OrderDetail>();
            cart = (List<OrderDetail>) session.getAttribute("cart");
            Set<OrderDetail> orderDetailsSet = orderProduct.getOrderDetailSet();
            List<OrderDetail> orderDetails = new ArrayList<>();
            orderDetails.addAll(orderDetailsSet);
            mailService.sendConfirmMail(
                    customerInfo.getEmail(),
                    "receipt",
                    "Thank you for purchasing at TravelGuide!",
                    orderProduct,
                    orderDetails,
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(orderProduct.getCreatedAt()), TimeZone.getDefault().toZoneId())
                    );
            for (AdminInfo adminInfo: adminInfos
                 ) {
                mailService.sendConfirmMail(
                        adminInfo.getEmail(),
                        "receipt",
                        "New order from customer: " + customerInfo.getEmail(),
                        orderProduct,
                        orderDetails,
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(orderProduct.getCreatedAt()), TimeZone.getDefault().toZoneId())
                );
            }
            orderProduct.setCustomerInfo(customerInfo);
            orderProductRepository.save(orderProduct);
            session.removeAttribute("cart");
            return "redirect:/customer/receipt";
        }
        else {
            return "error";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cart(HttpSession session, Model model,
                       @RequestParam(value = "orderProductId", required = false) String orderProductId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String userName = auth.getName();
            Account account = accountService.findByUserName(userName);
            if (account != null) {
                CustomerInfo customerInfo = customerInfoService.getCustomerInfoByAccount(account.getId());
                if (customerInfo != null) {
                    String message = "Order does not exist!";
                    double totalPrice = 0;
                    OrderProduct orderProduct = null;
//        khi khách hàng confirm thì chưa có orderProduct, nhưng khi khách hàng thanh toán thì đã có
                    if (orderProductId != null) {
                        orderProduct = orderProductService.getOrderProductByIdAndStatus(Long.parseLong(orderProductId) , 1);
                        if (orderProduct != null) {
                            Set<OrderDetail> orderDetails = orderProduct.getOrderDetailSet();
                            for (OrderDetail orderDetail : orderDetails
                            ) {
                                totalPrice = totalPrice + orderDetail.getCurrentPrice();
                            }
                            model.addAttribute("orderDetails", orderDetails);
                        }
                    } else {
                        List<OrderDetail> orderDetails = (List<OrderDetail>) session.getAttribute("cart");
                        if (orderDetails == null || orderDetails.size() <= 0) {
                            model.addAttribute("orderDetails", orderDetails);
                            message = "You haven't had any item in cart yet. Please go back to choose products to add to your cart!";
                            model.addAttribute("message", message);
                            return "customer/checkout";
                        }
                        orderProduct = new OrderProduct();
                        for (OrderDetail orderDetail : orderDetails
                        ) {
                            totalPrice = totalPrice + orderDetail.getCurrentPrice();
                            orderDetail.setOrderProduct(orderProduct);
                        }
                        orderProduct.setCustomerEmail(customerInfo.getEmail());
                        orderProduct.setCustomerName(customerInfo.getFullName());
                        orderProduct.setCustomerPhone(customerInfo.getPhone());
                        model.addAttribute("orderDetails", orderDetails);
                    }
                    model.addAttribute("orderProduct", orderProduct);
                    model.addAttribute("accountId", account.getId());
                    model.addAttribute("totalPrice", totalPrice);
                    model.addAttribute("message", message);
                    return "customer/checkout";
                }
            }
        }
        return "error";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(HttpSession session, OrderProduct orderProduct,
                           @RequestParam("accountId") long accountId) {
        OrderProduct existOrderProduct = orderProductService.getOrderProductById(orderProduct.getId());
        if(existOrderProduct != null){
            existOrderProduct.setCustomerPhone(orderProduct.getCustomerPhone());
            existOrderProduct.setCustomerName(orderProduct.getCustomerName());
            existOrderProduct.setCustomerEmail(orderProduct.getCustomerEmail());
            existOrderProduct.setStatus(3); // 3.paid
            OrderProduct updatedOrderProduct = orderProductService.update(existOrderProduct);
            if (updatedOrderProduct != null) {
                sendConfirmMessage(orderProduct.getCustomerEmail(), "paid");
            }
            return "redirect:/customer/home";
        }
        return "error";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(HttpSession session, OrderProduct orderProduct,
                         @RequestParam("accountId") long accountId) {
        orderProductService.delete(orderProduct);
        return "redirect:/customer/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/receipt")
    public String receipt(Model model, @RequestParam(value = "orderProductId") String orderProductId){
        OrderProduct orderProduct = null;
        if (orderProductId == null){
            return "redirect:/customer/home";
        } else {
            orderProduct =  orderProductService.getOrderProductById(Long.parseLong(orderProductId));
            if (orderProduct == null){
                return "redirect:/customer/home";
            }
        }
        Set<OrderDetail> orderDetailsSet = orderProduct.getOrderDetailSet();
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.addAll(orderDetailsSet);
        account = orderProduct.getCustomerInfo().getAccount();
        model.addAttribute("orderProduct", orderProduct);
        model.addAttribute("createdAt", LocalDateTime.ofInstant(Instant.ofEpochMilli(orderProduct.getCreatedAt()),
                TimeZone.getDefault().toZoneId()));
        model.addAttribute("orderDetails", orderDetails);
        return "customer/receipt";
    }
}
