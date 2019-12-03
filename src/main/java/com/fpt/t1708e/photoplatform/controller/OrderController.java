package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import com.fpt.t1708e.photoplatform.repository.OrderProductRepository;
import com.fpt.t1708e.photoplatform.service.OrderDetailService;
import com.fpt.t1708e.photoplatform.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable long id){
        List<OrderDetail> orderDetailList = orderDetailService.getByOrderProductId(id);
        if (orderDetailList == null) {
            return "/404";
        }
        model.addAttribute("orderDetailList", orderDetailList);
        model.addAttribute("orderProduct", orderProductService.getById(id));
        return "manager/studio/confirmation/confirm";
    }
}
