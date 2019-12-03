package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Controller
@RequestMapping(value = "/studio")
public class StudioController {
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	AlbumService albumService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	StudioInfoService studioInfoService;
	@Autowired
	PhotographerInfoService photographerInfoService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		StudioInfo studioInfo = studioInfoService.getById(id);
		if (studioInfo == null) {
			return "/404";
		}
		List<Category> categories = new ArrayList<>();
		Set<Product> productList = studioInfo.getProductSet();
		for(Product product : productList){
			if (!categories.contains(product.getCategory())){
				categories.add(product.getCategory());
			}
		}
		model.addAttribute("info", studioInfo);
		model.addAttribute("categories", categories);
		return "manager/studio/studio-photographer/detail";
	}

}
