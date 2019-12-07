package com.fpt.t1708e.photoplatform.service;

import java.util.List;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;

import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;

@Service
public class PhotographerInfoService {
	@Autowired
	PhotographerInfoRepository photographerInfoRepository;

	public List<PhotographerInfo> getAll() {
		return photographerInfoRepository.findAll();
	}
	public PhotographerInfo getById(long id){return photographerInfoRepository.findById(id).orElse(null);}

    public List<PhotographerInfo> getByTopRate() {
		List<PhotographerInfo> photographerInfoList = photographerInfoRepository.getTop10Rating();

		return photographerInfoList;
    }

    public List<PhotographerInfo> getAllByKey(String key) {
		return photographerInfoRepository.getAllByKey(key);
    }
}
