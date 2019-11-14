package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Product;
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

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model){
		model.addAttribute("categories", categoryService.getList());
		return "category/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(Model model) {
		model.addAttribute("category", new Category());
		return "category/create";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String store(Model model, @Valid Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("category", category);
			return "/create";
		}
		category.setProductSet(null);
		categoryService.create(category);
        return "redirect:/category/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Category category = categoryService.getCategoryById(id);
		if (category == null) {
            return "error/404";
		}
		model.addAttribute("category", category);
		return "category/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
	public String update(@PathVariable int id, Model model, Category updateCategory) {
		Category category = categoryService.getCategoryById(id);
		if (category == null) {
            return "error/404";
		}
		category.setName(updateCategory.getName());
		category.setDescription(updateCategory.getDescription());
		category.setThumbnail(updateCategory.getThumbnail());
		category.setStatus(updateCategory.getStatus());
		categoryService.update(category);
        return "redirect:/category/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable long id) {
		Category category = categoryService.getCategoryById(id);
		if (category == null) {
			return "/404";
		}
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getByCategoryId(id));
		return "category/detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public String delete(Model model, @PathVariable int id){
		Category category = categoryService.getCategoryById(id);
		if (category == null){
			return "/404";
		}
		category.setStatus(0);
		categoryService.update(category);
		return "category/list";
	}
}
