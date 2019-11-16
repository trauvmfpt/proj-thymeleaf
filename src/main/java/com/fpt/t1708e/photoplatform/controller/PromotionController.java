package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.Promotion;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.CategoryService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/promotion")
public class PromotionController {
	@Autowired
	PromotionService promotionService;
	@Autowired
	AccountService accountService;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	static Account account = new Account();

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model){
		model.addAttribute("promotions", promotionService.promotions());
		return "promotion/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(Model model) {
		Random rnd = new Random();
		List<Account> listAccAdmin = accountService.findAllAccountByRole(5);
		account = listAccAdmin.get(rnd.nextInt(listAccAdmin.size()));
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("categories", categoryService.categories());
		return "promotion/create";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String store(Model model, @Valid Promotion promotion, @RequestParam("categoryId") String categoryId,
						BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("promotion", promotion);
			return "/create";
		}
		long longCateId = Long.parseLong(categoryId);
		Category selectedCategory = categoryService.getCategoryById(longCateId);
		Set<Product> products = selectedCategory.getProductSet();
		List<Product> products1 = new ArrayList<>();
		products1.addAll(products);
//		promotion.setProductSet(products);
		promotion.addProduct(products1.get(0)); // Em foreach rồi nhét lại vào hàm addProduct nhé
//		promotion.setProductSet(null);

		promotion.setAdminInfo(accountService.findByUserName(account.getUsername()).getAdminInfo());
		promotionService.create(promotion);
        return "redirect:/promotion/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null) {
            return "error/404";
		}
		model.addAttribute("promotion", promotion);
		model.addAttribute("categories", categoryService.categories());
		return "promotion/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
	public String update(@PathVariable int id, Model model, @RequestParam("categoryId") String categoryId,
						 Promotion updatePromotion) {
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null) {
            return "error/404";
		}
		long longCateId = Long.parseLong(categoryId);
		Category selectedCategory = categoryService.getCategoryById(longCateId);
		Set<Product> products = selectedCategory.getProductSet();

		promotion.setAdminInfo(updatePromotion.getAdminInfo());
		promotion.setName(updatePromotion.getName());
		promotion.setDescription(updatePromotion.getDescription());
		promotion.setDiscount(updatePromotion.getDiscount());
		promotion.setProductSet(products);
		promotion.setStatus(updatePromotion.getStatus());
		promotionService.update(promotion);
        return "redirect:/promotion/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable long id) {
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null) {
			return "/404";
		}
		model.addAttribute("promotion", promotion);
		model.addAttribute("products", promotion.getProductSet());
		return "promotion/detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public String delete(Model model, @PathVariable int id){
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null){
			return "/404";
		}
		promotion.setStatus(0);
		promotionService.update(promotion);
		return "promotion/list";
	}
}
