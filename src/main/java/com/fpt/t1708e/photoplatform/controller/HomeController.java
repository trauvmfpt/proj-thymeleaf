package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.AdminInfo;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Comment;
import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.Picture;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.Rank;
import com.fpt.t1708e.photoplatform.entity.Rating;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;
import com.fpt.t1708e.photoplatform.repository.AdminInfoRepository;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import com.fpt.t1708e.photoplatform.repository.CategoryRepository;
import com.fpt.t1708e.photoplatform.repository.CommentRepository;
import com.fpt.t1708e.photoplatform.repository.LevelRepository;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.PictureRepository;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import com.fpt.t1708e.photoplatform.repository.RankRepository;
import com.fpt.t1708e.photoplatform.repository.RatingRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import com.fpt.t1708e.photoplatform.service.AlbumService;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.StudioInfoService;
import com.fpt.t1708e.photoplatform.util.ProvinceStringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping({"/home", ""})
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    StudioInfoService studioInfoService;
    @Autowired
    PhotographerInfoService photographerInfoService;
    @Autowired
    AlbumService albumService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> productList = productService.getProductByDiscountEachCategory();
        for (Product product : productList
        ) {
            if (product != null) {
                product.setPriceDiscount((int) Math.round(product.getPriceDiscount() / product.getPrice() * 100));
            }
        }
        model.addAttribute("discountProducts", productList);
        model.addAttribute("rateProduct", productService.getProductByTopRate());
//		model.addAttribute("rateProduct",productService.getProductBestSeller());
        model.addAttribute("rateStudios", studioInfoService.getStudioByTopRate());
        model.addAttribute("ratePhotographers", photographerInfoService.getByTopRate());
        model.addAttribute("rateAlbum", albumService.getByTopRate());
        return "customer/home";
//		return "admin-layout/admin-layout";
    }

    @RequestMapping(value = "/detail")
    public String detail() {
        return "manager/studio/studio-photographer/detail";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "customer/checkout";
    }
}
