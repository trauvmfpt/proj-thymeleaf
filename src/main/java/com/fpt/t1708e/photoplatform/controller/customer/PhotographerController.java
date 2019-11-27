package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/photographer")
public class PhotographerController {
    @Autowired
    PhotographerInfoService photographerInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable int id) {
        PhotographerInfo photographerInfo = photographerInfoService.getById(id);
        if (photographerInfo == null) {
            return "/404";
        }
        model.addAttribute("studioInfo", photographerInfo);
        return "manager/studio/studio-photographer/detail";
    }
}
