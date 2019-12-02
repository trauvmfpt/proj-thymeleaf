package com.fpt.t1708e.photoplatform.controller.customer;


import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        List<Category> categories = new ArrayList<>();
        Set<Product> productList = photographerInfo.getProductSet();
        for(Product product : productList){
            System.out.println(product.getCategory().getName());
            if (!categories.contains(product.getCategory())){
                categories.add(product.getCategory());
            }
        }
        model.addAttribute("info", photographerInfo);
        model.addAttribute("categories", categories);
        return "manager/studio/studio-photographer/detail";
    }
}
