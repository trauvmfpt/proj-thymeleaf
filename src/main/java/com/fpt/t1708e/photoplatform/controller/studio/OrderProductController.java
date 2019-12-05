package com.fpt.t1708e.photoplatform.controller.studio;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderProductController {

	@Autowired
	OrderProductService orderProductService;

	@Autowired
	OrderDetailService orderDetailService;

	static Account account = new Account();

	@RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model) {
		List<OrderProduct> listOrders = orderProductService.orders();
        model.addAttribute("orders", listOrders);
        return "manager/order/list";
    }

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
