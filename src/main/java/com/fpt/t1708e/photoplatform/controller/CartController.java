package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.*;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.CustomerInfoService;
import com.fpt.t1708e.photoplatform.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    AccountService accountService;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    public JavaMailSender emailSender;

    static Account account = new Account();

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
        if(product == null){
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

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirm(HttpSession session, OrderProduct orderProduct,
                          @RequestParam("accountId") long accountId) {
        if (session.getAttribute("cart") != null) {
            CustomerInfo customerInfo = customerInfoService.getCustomerInfoByAccount(accountId);
            if(customerInfo == null){
                return "error";
            }
            List<OrderDetail> cart = new ArrayList<OrderDetail>();
            cart = (List<OrderDetail>) session.getAttribute("cart");
            for (OrderDetail orderDetail: cart
                 ) {
                orderDetail.setOrderProduct(orderProduct);
                orderProduct.addOrderDetail(orderDetail);

                Product product = orderDetail.getProduct();
                if (product.getStudioInfo() != null){
                    sendConfirmMessage(product.getStudioInfo().getEmail(), product.getName());

                } else {
                    sendConfirmMessage(product.getPhotographerInfo().getEmail(), product.getName());
                }
            }
            orderProduct.setCustomerInfo(customerInfo);
            orderProductRepository.save(orderProduct);
            session.removeAttribute("cart");
            return "redirect:/customer/home";
        }
        else {
            return "error";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String cart(HttpSession session, Model model,
                       @RequestParam(value = "orderProductId", required = false) String orderProductId){
        List<OrderDetail> orderDetails = (List<OrderDetail>) session.getAttribute("cart");
        if (orderDetails == null){
//            model.addAttribute("orderProduct", null);
            return "customer/checkout";
        }
        model.addAttribute("orderDetails", orderDetails);
        Random rnd = new Random();
        List<Account> accounts = accountService.findAllAccountByRole(1);
        account = accounts.get(rnd.nextInt(accounts.size()));

        OrderProduct orderProduct = null;
//        khi khách hàng confirm thì chưa có orderProduct, nhưng khi khách hàng thanh toán thì đã có
        if (orderProductId == null){
            orderProduct =  new OrderProduct();
        } else {
            orderProduct =  orderProductService.getOrderProductById(Long.parseLong(orderProductId));
        }
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoByAccount(account.getId());
        orderProduct.setCustomerInfo(customerInfo);
        orderProduct.setCustomerEmail(customerInfo.getEmail());
        orderProduct.setCustomerName(customerInfo.getFullName());
        orderProduct.setCustomerPhone(customerInfo.getPhone());
        model.addAttribute("orderProduct", orderProduct);
        model.addAttribute("accountId", account.getId());
        return "customer/checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(HttpSession session, OrderProduct orderProduct,
                           @RequestParam("accountId") long accountId){
//        do check out here
        orderProduct.setStatus(2); // 2: paid?
        orderProductService.update(orderProduct);
        return "redirect:/customer/home";
    }
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(HttpSession session, OrderProduct orderProduct,
                           @RequestParam("accountId") long accountId){
        orderProductService.delete(orderProduct);
        return "redirect:/customer/home";
    }

    public void sendConfirmMessage(String to, String text) {
        try {
            MimeMessage mail = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mail, true);
            messageHelper.setTo(to);
            messageHelper.setSubject("You have a new order to confirm!");
            messageHelper.setText(text, true);
            emailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
