package com.fpt.t1708e.photoplatform.controller.admin;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.CategoryService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Controller
@RequestMapping(value = "owner/promotion")
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
		return "owner/admin/promotion/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(Model model) {
		Random rnd = new Random();
		List<Account> listAccAdmin = accountService.findAllAccountByRole(5);
		account = listAccAdmin.get(rnd.nextInt(listAccAdmin.size()));
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("categories", categoryService.categories());
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "owner/admin/promotion/create";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String store(Model model, @Valid Promotion promotion, BindingResult bindingResult,
						@RequestParam("categoryId") String categoryId,
						@RequestParam("expiredAtString") String expiredAtString) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("promotion", promotion);
			return "owner/admin/promotion/create";
		}
		LocalDateTime date = LocalDateTime.parse(expiredAtString);
		long expiredAt = date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long longCateId = Long.parseLong(categoryId);
		Category selectedCategory = categoryService.getCategoryById(longCateId);
		Set<Product> products = selectedCategory.getProductSet();
		List<Product> products1 = new ArrayList<>();
		products1.addAll(products);
//		promotion.setProductSet(products);
		for (Product product:
				products1) {
			promotion.addProduct(product);
		}
//		promotion.setProductSet(null);

		promotion.setAdminInfo(accountService.findByUserName(account.getUsername()).getAdminInfo());
		promotion.setExpiredAt(expiredAt);
		promotionService.create(promotion);
        return "redirect:/promotion/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null) {
            return "error/404";
		}
		Set<Product> productSet = promotion.getProductSet();
		Iterator<Product> iterator = productSet.iterator();
		Product firstProduct = iterator.next();
		Category selectedCategory = firstProduct.getCategory();
		model.addAttribute("promotion", promotion);
		model.addAttribute("categories", categoryService.categories());
		model.addAttribute("selectedCategory", selectedCategory.getId());
		model.addAttribute("currentExpiredAt", LocalDateTime.ofInstant(Instant.ofEpochMilli(promotion.getExpiredAt()),
				TimeZone.getDefault().toZoneId()));
		return "owner/admin/promotion/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
	public String update(@PathVariable int id, Model model, @RequestParam("categoryId") String categoryId,
						 @RequestParam("expiredAtString") String expiredAtString,
						 Promotion updatePromotion) {
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null) {
            return "error/404";
		}
		long longCateId = Long.parseLong(categoryId);
		Category selectedCategory = categoryService.getCategoryById(longCateId);
		Set<Product> products = selectedCategory.getProductSet();
		List<Product> products1 = new ArrayList<>();
		products1.addAll(products);
//		promotion.setProductSet(products);
		promotion.setProductSet(null);
		for (Product product:
				products1) {
			promotion.addProduct(product);
		}
//		promotion.setProductSet(null);

		promotion.setAdminInfo(accountService.findByUserName(account.getUsername()).getAdminInfo());

//		promotion.setAdminInfo(updatePromotion.getAdminInfo());

		promotion.setName(updatePromotion.getName());
		promotion.setDescription(updatePromotion.getDescription());
		promotion.setDiscount(updatePromotion.getDiscount());
		promotion.setStatus(updatePromotion.getStatus());
		LocalDateTime date = LocalDateTime.parse(expiredAtString);
		long expiredAt = date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		promotion.setExpiredAt(expiredAt);
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
		return "owner/admin/promotion/detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public String delete(Model model, @PathVariable int id){
		Promotion promotion = promotionService.getPromotionById(id);
		if (promotion == null){
			return "/404";
		}
		promotion.setStatus(0);
		promotionService.update(promotion);
		return "owner/admin/promotion/list";
	}
}
