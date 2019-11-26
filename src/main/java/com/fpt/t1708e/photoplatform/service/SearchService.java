package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.entity.rest.RESTSearch;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    PhotographerInfoRepository photographerInfoRepository;
    @Autowired
    StudioInfoRepository studioInfoRepository;
    @Autowired
    ProductRepository productRepository;


    public List<RESTSearch> searchTop5(String key){
        List<RESTSearch> restSearchList = new ArrayList<>();
        List<Product> productList = productRepository.getTop5(key);
        for (Product product: productList
        ) {
            RESTSearch restSearch = new RESTSearch();
            restSearch.setId(String.valueOf(product.getId()));
            restSearch.setName(String.valueOf(product.getDestination()));
            restSearch.setType("Địa điểm");
            restSearch.setAddress(product.getArea());
            restSearch.setUrl(String.format("/product/"+ product.getId()));
            restSearchList.add(restSearch);
        }
        List<PhotographerInfo> photographerInfos = photographerInfoRepository.getTop5(key);
        for (PhotographerInfo photographerInfo: photographerInfos
             ) {
            RESTSearch restSearch = new RESTSearch();
            restSearch.setId(String.valueOf(photographerInfo.getId()));
            restSearch.setName(String.valueOf(photographerInfo.getFullName()));
            restSearch.setType("Photographer");
            restSearch.setAddress(photographerInfo.getAddress());
            restSearch.setUrl(String.format("/studio/"+ photographerInfo.getId()));
            restSearchList.add(restSearch);
        }
        List<StudioInfo> studioInfoList = studioInfoRepository.getTop5(key);
        for (StudioInfo studioInfo:studioInfoList
             ) {
            RESTSearch restSearch = new RESTSearch();
            restSearch.setId(String.valueOf(studioInfo.getId()));
            restSearch.setName("Studio");
            restSearch.setType(StudioInfo.class.getSimpleName());
            restSearch.setAddress(studioInfo.getAddress());
            restSearch.setUrl(String.format("/studio/"+ studioInfo.getId()));
            restSearchList.add(restSearch);
        }

        return restSearchList;
    };
}
