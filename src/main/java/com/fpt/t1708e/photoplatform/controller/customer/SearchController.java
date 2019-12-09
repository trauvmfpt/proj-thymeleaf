package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.service.AlbumService;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import com.fpt.t1708e.photoplatform.service.ProductService;
import com.fpt.t1708e.photoplatform.service.StudioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    AlbumService albumService;
    @Autowired
    ProductService productService;
    @Autowired
    StudioInfoService studioInfoService;
    @Autowired
    PhotographerInfoService photographerInfoService;
    @RequestMapping(method = RequestMethod.GET)
    public String searchAllByKey(Model model,@RequestParam("key") String key){
        if (key == ""){
            return "redirect:/";
        }
        List<String> keyList = new LinkedList<String>(Arrays.asList(key.split("-|\\s")));
        keyList.removeIf(s -> s.toLowerCase().contains("chụp") || s.toLowerCase().contains("ảnh"));
        if(keyList.size() == 0){
            return "redirect:/";
        }
        List<Album> albumList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<StudioInfo> studioInfoList = new ArrayList<>();
        List<PhotographerInfo> photographerInfoList = new ArrayList<>();
        for (String singleKey : keyList
        ){
            List<Album> albumListTemp = albumService.getAllByKey(singleKey);
            albumList.addAll(albumListTemp);
            List<Product> productListTemp = productService.getAllByKey(singleKey);
            productList.addAll(productListTemp);
            List<StudioInfo> studioInfoListTemp = studioInfoService.getAllByKey(singleKey);
            studioInfoList.addAll(studioInfoListTemp);
            List<PhotographerInfo> photographerInfoListTemp = photographerInfoService.getAllByKey(singleKey);
            photographerInfoList.addAll(photographerInfoListTemp);
        }
        albumList = albumList.stream().distinct().collect(Collectors.toList());
        productList = productList.stream().distinct().collect(Collectors.toList());
        studioInfoList = studioInfoList.stream().distinct().collect(Collectors.toList());
        photographerInfoList = photographerInfoList.stream().distinct().collect(Collectors.toList());

        model.addAttribute("albumList",albumList);
        model.addAttribute("productList",productList);
        model.addAttribute("studioInfoList",studioInfoList);
        model.addAttribute("photographerInfoList",photographerInfoList);
        return "customer/searchResult";
    }
}
