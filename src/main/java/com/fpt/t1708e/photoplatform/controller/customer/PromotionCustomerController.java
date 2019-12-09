package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.Promotion;
import com.fpt.t1708e.photoplatform.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/promotion")
public class PromotionCustomerController {
    @Autowired
    PromotionService promotionService;
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    public String list(Model model){
        model.addAttribute("promotionList",promotionService.findAll());
        return "customer/promotion/list";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detail(Model model, @RequestParam("id") long id){
        Promotion promotion = promotionService.getPromotionById(id);
        promotion.setExpiredAt(TimeUnit.MILLISECONDS.toDays(promotion.getExpiredAt()));
        model.addAttribute("promotion",promotion);

        return "customer/promotion/detail";
    }
}
