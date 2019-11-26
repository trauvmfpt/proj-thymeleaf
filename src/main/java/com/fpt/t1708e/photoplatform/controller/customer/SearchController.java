package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.rest.RESTSearch;
import com.fpt.t1708e.photoplatform.service.PhotographerInfoService;
import com.fpt.t1708e.photoplatform.service.SearchService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    SearchService searchService;
    @RequestMapping(method = RequestMethod.GET)
    public List<RESTSearch> fullSearch(@RequestParam("key") String searchKey){

//        return new Gson().toJson(searchService.searchTop5(searchKey));
        return searchService.searchTop5(searchKey);
    }
}
