package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.rest.RESTSearch;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
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

    public List<RESTSearch> searchTop5(String key){
        List<RESTSearch> restSearchList = new ArrayList<>();
        List<PhotographerInfo> photographerInfos = photographerInfoRepository.getTop5(key);
        for (PhotographerInfo photographerInfo: photographerInfos
             ) {
            RESTSearch restSearch = new RESTSearch();
            restSearch.setId(String.valueOf(photographerInfo.getId()));
            restSearch.setName(String.valueOf(photographerInfo.getFullName()));
            restSearch.setType(PhotographerInfo.class.getSimpleName());
            restSearch.setAddress(photographerInfo.getAddress());
            restSearch.setUrl(String.format("/studio/"+ photographerInfo.getId()));
            restSearchList.add(restSearch);
        }

        return restSearchList;
    };
}
