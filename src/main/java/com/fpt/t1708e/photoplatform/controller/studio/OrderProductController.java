package com.fpt.t1708e.photoplatform.controller.studio;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import com.fpt.t1708e.photoplatform.repository.OrderProductRepository;
import com.fpt.t1708e.photoplatform.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/manager/order")
public class OrderProductController {

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    AccountService accountService;

    static Account account = new Account();

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            List<OrderProduct> listOrders = new ArrayList<>();
            if (account.getRole() == 5) {
                listOrders = orderProductService.orders();
            } else {
                List<OrderDetail> orderDetailList = orderDetailRepository.findByAccountId(account.getId());
                for (OrderDetail orderDetail : orderDetailList
                ) {
                    OrderProduct orderProduct = orderProductService.getById(orderDetail.getOrderProduct().getId());
                    listOrders.add(orderProduct);
                }
            }
            if (listOrders == null) {
                return "/404";
            }
            model.addAttribute("orders", listOrders);
            return "manager/order/list";
        }
        return "error";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    public String detail(Model model, @PathVariable long orderId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            List<OrderDetail> orderDetailList = new ArrayList<>();
            if (account.getRole() == 5) {
                orderDetailList = orderDetailService.getByOrderProductId(orderId);
            } else {
                orderDetailList = orderDetailRepository.findByAccountIdAndOrderId(account.getId(), orderId);
            }
            if (orderDetailList == null) {
                return "/404";
            }
            model.addAttribute("orderDetailList", orderDetailList);
            model.addAttribute("orderProduct", orderProductService.getById(orderId));
            return "manager/studio/confirmation/confirm";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/confirmOrderDetail", method = RequestMethod.POST)
    public ResponseEntity<Object> confirmOrderDetail(@RequestBody Long[] orderDetailIds) {
        if (orderDetailIds != null && orderDetailIds.length > 0) {
            for (long orderDetailId : orderDetailIds
            ) {
                OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElse(null);
                if (orderDetail != null && orderDetail.getStatus() != 3) {
                    orderDetail.setStatus(3);
                    orderDetailRepository.save(orderDetail);
                }
            }
            return new ResponseEntity<>(new RESTResponse.Success()
                    .setStatus(HttpStatus.OK.value())
                    .setMessage("Action success!")
                    .addData(new Gson().toJson(orderDetailIds))
                    .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @RequestMapping(value = "/cancelOrderDetail", method = RequestMethod.POST)
    public ResponseEntity<Object> cancelOrderDetail(@RequestBody Long[] orderDetailIds) {
        if (orderDetailIds != null && orderDetailIds.length > 0) {
            for (long orderDetailId : orderDetailIds
            ) {
                OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElse(null);
                if (orderDetail != null && orderDetail.getStatus() != 1) {
                    orderDetail.setStatus(1);
                    orderDetailRepository.save(orderDetail);
                }
            }
            return new ResponseEntity<>(new RESTResponse.Success()
                    .setStatus(HttpStatus.OK.value())
                    .setMessage("Action success!")
                    .addData(new Gson().toJson(orderDetailIds))
                    .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    public ResponseEntity<Object> confirmOrder(@RequestBody Long[] orderIds) {
        if (orderIds != null && orderIds.length > 0) {
            for (long orderId : orderIds
            ) {
                OrderProduct orderProduct = orderProductService.getById(orderId);
                if (orderProduct != null) {
                    if(orderProduct.getStatus() != 3 && orderProduct.getStatus() != 2){
                        List<OrderDetail> orderDetails = orderDetailService.getByOrderProductId(orderProduct.getId());
                        if(orderDetails != null && orderDetails.size() > 0){
                            for (OrderDetail orderDetail: orderDetails
                            ) {
                                orderDetail.setStatus(3);
                                orderDetailRepository.save(orderDetail);
                            }
                        }
                        orderProduct.setStatus(2);
                        orderProductService.update(orderProduct);
                    }
                }
            }
            return new ResponseEntity<>(new RESTResponse.Success()
                    .setStatus(HttpStatus.OK.value())
                    .setMessage("Action success!")
                    .addData(new Gson().toJson(orderIds))
                    .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public ResponseEntity<Object> cancelOrder(@RequestBody Long[] orderIds) {
        if (orderIds != null && orderIds.length > 0) {
            for (long orderId : orderIds
            ) {
                OrderProduct orderProduct = orderProductService.getById(orderId);
                if (orderProduct != null) {
                    if(orderProduct.getStatus() != 0 && orderProduct.getStatus() != 3){
                        List<OrderDetail> orderDetails = orderDetailService.getByOrderProductId(orderProduct.getId());
                        if(orderDetails != null && orderDetails.size() > 0){
                            for (OrderDetail orderDetail: orderDetails
                            ) {
                                orderDetail.setStatus(1);
                                orderDetailRepository.save(orderDetail);
                            }
                        }
                        orderProduct.setStatus(0);
                        orderProductService.update(orderProduct);
                    }
                }
            }
            return new ResponseEntity<>(new RESTResponse.Success()
                    .setStatus(HttpStatus.OK.value())
                    .setMessage("Action success!")
                    .addData(new Gson().toJson(orderIds))
                    .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
