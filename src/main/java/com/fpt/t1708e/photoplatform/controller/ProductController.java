package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.AlbumService;
import com.fpt.t1708e.photoplatform.service.CategoryService;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.StudioInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

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

	static Account account = new Account();

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(Model model) {
		Random rnd = new Random();
		List<Account> listAcc1 = accountService.findAllAccountByRole(2);
		List<Account> listAcc2 = accountService.findAllAccountByRole(3);
		listAcc1.addAll(listAcc2);
		account = listAcc1.get(rnd.nextInt(listAcc1.size()));

		List<Album> albums = new ArrayList<Album>();
		if (account.getRole() == 2) {
			albums = albumService.albumsByStudio(account.getStudioInfo());
		} else if (account.getRole() == 3) {
			albums = albumService.albumsByPhotographer(account.getPhotographerInfo());
		}
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.categories());
		model.addAttribute("albums", albums);
		return "product/create";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String store(Model model, @Valid Product product, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "product/create";
		}

		product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		product.setAlbum(albumService.albumById(product.getAlbum().getId()));
		if (account.getRole() == 2) {
			product.setStudioInfo(account.getStudioInfo());
		} else if (account.getRole() == 3) {
			product.setPhotographerInfo(account.getPhotographerInfo());
		}

		productService.create(product);
//        return "redirect:/product/list";
		return "ok";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable int id, Model model) {

		Product product = productService.getById(id);
		if (product == null) {
//            return "error/404";
			return "not ok";
		}
		if (product.getStudioInfo() != null) {			
			model.addAttribute("albums", albumService.albumsByStudio(account.getStudioInfo()));
		}else {
			model.addAttribute("albums", albumService.albumsByPhotographer(account.getPhotographerInfo()));
		}
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.categories());
		
		return "product/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
	public String update(@PathVariable int id, Model model, Product updateProduct) {
		Product product = productService.getById(id);
		if (product == null) {
//            return "error/404";
			return "not ok";
		}
		product.setName(updateProduct.getName());
		product.setDescription(updateProduct.getDescription());
		product.setContent(updateProduct.getContent());
		product.setPrice(updateProduct.getPrice());
		product.setPriceDiscount(updateProduct.getPriceDiscount());
		product.setArea(updateProduct.getArea());
		product.setDestination(updateProduct.getDestination());
		product.setThumbnail(updateProduct.getThumbnail());
		product.setStatus(updateProduct.getStatus());
		if (product.getAlbum().getId() != updateProduct.getAlbum().getId()) {
			product.getAlbum().getProductSet().remove(product);
			product.setAlbum(albumService.albumById(updateProduct.getAlbum().getId()));
		}
		if (product.getCategory().getId() != updateProduct.getCategory().getId()) {
			product.getCategory().getProductSet().remove(product);
			product.setCategory(categoryService.getCategoryById(updateProduct.getCategory().getId()));
		}
		productService.update(product);
//        return "redirect:/product/list";
		return "ok";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		Product product = productService.getById(id);
		if (product == null) {
			return "/404";
		}
		model.addAttribute("product", product);
		return "product/detail";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model) {
        List<Product> products = productService.products();
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getList());
        return "product/list";
    }
}
