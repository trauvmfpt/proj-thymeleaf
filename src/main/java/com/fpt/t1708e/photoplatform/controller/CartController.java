package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

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

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(HttpSession session, OrderProduct orderProduct, long accountId) {
        if (session.getAttribute("cart") != null) {
            CustomerInfo customerInfo = customerInfoRepository.findByAccount_Id(accountId);
            if(customerInfo == null){
                return "error";
            }
            List<OrderDetail> cart = new ArrayList<OrderDetail>();
            cart = (List<OrderDetail>) session.getAttribute("cart");
            for (OrderDetail orderDetail: cart
                 ) {
                orderDetail.setOrderProduct(orderProduct);
                orderProduct.addOrderDetail(orderDetail);
            }
            orderProductRepository.save(orderProduct);
            session.removeAttribute("cart");
            return "product/list";
        }
        else {
            return "error";
        }
    }
}
