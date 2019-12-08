package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		Product product = productService.getById(id);
		if (product == null) {
			return "/404";
		}
		model.addAttribute("product", product);
		model.addAttribute("listProduct", productService.getList());
		return "customer/product/detail";
	}
 
	@RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model, @RequestParam(value = "photographer", required = false) String photographerId,
					   @RequestParam(value = "studio", required = false) String studioId,
					   @RequestParam(defaultValue = "1", required = false) Optional<Integer> page,
					   @RequestParam(defaultValue = "10", required = false) Optional<Integer> limit) {
		int currentPage = page.orElse(1);
		int pageSize = limit.orElse(5);
		if (photographerId == null || photographerId.equals("")){
			photographerId = String.valueOf(0);
			model.addAttribute("info", studioInfoService.getById(Long.parseLong(studioId)));
		}
		if (studioId == null || studioId.equals("")){
			studioId = String.valueOf(0);
			model.addAttribute("info", photographerInfoService.getById(Long.parseLong(photographerId)));
		}

		Page<Product> productPage = productService
				.productsWithPagination(Long.parseLong(photographerId), Long.parseLong(studioId),
						PageRequest.of(currentPage - 1, pageSize));
		model.addAttribute("products", productPage);


		int totalPages = productPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

        model.addAttribute("categories", categoryService.getList());
        return "customer/product/list";
    }
}
