package com.fpt.t1708e.photoplatform.controller.studio;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.AlbumService;
import com.fpt.t1708e.photoplatform.service.CategoryService;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.StudioInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "owner/product")
public class ManagerProductController {

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

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Account account = accountService.findByUserName(userName);
		if(account != null){
			List<Album> albums = new ArrayList<Album>();
			if (account.getRole() == 2) {
				albums = albumService.albumsByStudio(account.getStudioInfo());
			} else if (account.getRole() == 3) {
				albums = albumService.albumsByPhotographer(account.getPhotographerInfo());
			}
			model.addAttribute("product", new Product());
			model.addAttribute("categories", categoryService.categories());
			model.addAttribute("albums", albums);
			return "manager/studio/product/create";
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String store(Model model, @Valid Product product, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "manager/studio/product/create";
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Account account = accountService.findByUserName(userName);
		if(account != null){
			product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
			product.setAlbum(albumService.albumById(product.getAlbum().getId()));
			if (account.getRole() == 2) {
				product.setStudioInfo(account.getStudioInfo());
			} else if (account.getRole() == 3) {
				product.setPhotographerInfo(account.getPhotographerInfo());
			}
			productService.create(product);
			return "redirect:/list";
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Account account = accountService.findByUserName(userName);
		if(account != null){
			Product product = productService.getById(id);
			if (product == null) {
				return "error/404";
			}
			if (product.getStudioInfo() != null) {
				model.addAttribute("albums", albumService.albumsByStudio(account.getStudioInfo()));
			}else {
				model.addAttribute("albums", albumService.albumsByPhotographer(account.getPhotographerInfo()));
			}
			model.addAttribute("product", product);
			model.addAttribute("categories", categoryService.categories());

			return "manager/studio/product/edit";
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}")
	public String update(@PathVariable int id, Model model, Product updateProduct) {
		Product product = productService.getById(id);
		if (product == null) {
            return "error/404";
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
        return "redirect:owner/product/list";
//		return "ok";
	}
//    For admin/studio/photographer

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String adminList(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Account account = accountService.findByUserName(userName);
		if(account != null){
			List<Product> products = new ArrayList<>();
			if(account.getRole() == 2){
				products = productRepository.getProductByStudioInfoId(account.getStudioInfo().getId());
			}
			if(account.getRole() == 3){
				products = productRepository.getProductByPhotographerInfoId(account.getPhotographerInfo().getId());
			}
			if(account.getRole() == 5){
				products = productRepository.findAll();
			}
			model.addAttribute("products", products);
			return "manager/studio/product/list";
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String adminDetail(Model model, @PathVariable int id) {
		Product product = productService.getById(id);
		if (product == null) {
			return "/404";
		}
		model.addAttribute("product", product);
		return "manager/studio/product/detail";
	}

}
