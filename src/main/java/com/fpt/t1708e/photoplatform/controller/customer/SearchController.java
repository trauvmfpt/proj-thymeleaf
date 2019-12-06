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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<String> keyList = new LinkedList<String>(Arrays.asList(key.split("\\s")));
        keyList.removeIf(s -> s.toLowerCase().contains("chụp") || s.toLowerCase().contains("ảnh"));
        if(keyList.size() == 0){
            return "redirect:/";
        }
        List<Album> albumList = albumService.getAllByKey(key);
        List<Product> productList = productService.getAllByKey(key);
        List<StudioInfo> studioInfoList = studioInfoService.getAllByKey(key);
        List<PhotographerInfo> photographerInfoList = photographerInfoService.getAllByKey(key);
        model.addAttribute("albumList",albumList);
        model.addAttribute("productList",productList);
        model.addAttribute("studioInfoList",studioInfoList);
        model.addAttribute("photographerInfoList",photographerInfoList);
        return "customer/searchResult";
    }
}
