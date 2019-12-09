package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/history")
public class OrderHistory {
    @Autowired
    AccountService accountService;
    @Autowired
    OrderProductService orderProductService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        List<OrderProduct> orderProductList = new ArrayList<>(account.getCustomerInfo().getOrderProductSet());
        orderProductList = orderProductList.stream().sorted((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt())).collect(Collectors.toList());
        model.addAttribute("orderProductList",orderProductList);
        return "customer/order/history";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detail(Model model,@RequestParam("id") long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (id != 0){
            OrderProduct orderProduct = orderProductService.getById(id);
            model.addAttribute("orderProduct",orderProduct);
            return "customer/order/historyDetail";
        }
        return "error/404";
    };
}
