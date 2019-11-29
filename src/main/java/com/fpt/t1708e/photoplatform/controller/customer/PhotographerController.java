package com.fpt.t1708e.photoplatform.controller.customer;


import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/photographer")
public class PhotographerController {
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	AlbumService albumService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PhotographerInfoService photographerInfoService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		PhotographerInfo photographerInfo = photographerInfoService.getById(id);
		if (photographerInfo == null) {
			return "/404";
		}
		model.addAttribute("photographerInfo", photographerInfo);
		return "photographer/detail";
	}

    @RequestMapping(method = RequestMethod.GET, value = "/studio/{id}")
    public String detail1(Model model, @PathVariable int id) {
        PhotographerInfo photographerInfo = photographerInfoService.getById(id);
        if (photographerInfo == null) {
            return "/404";
        }
        model.addAttribute("studioInfo", photographerInfo);
        return "manager/studio/studio-photographer/detail";
    }
}
