package com.fpt.t1708e.photoplatform.service;

import java.util.List;

import com.fpt.t1708e.photoplatform.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;

@Service
public class StudioInfoService {
	@Autowired
	StudioInfoRepository studioInfoRepository;

	public List<StudioInfo> getAll() {
		return studioInfoRepository.findAll();
	}
	public StudioInfo getById(long id){return studioInfoRepository.findById(id).orElse(null);}
	public List<StudioInfo> getStudioByTopRate(){

		List<StudioInfo> studioInfoList = studioInfoRepository.getTop10Rating();

		return studioInfoList;
	}

    public List<StudioInfo> getAllByKey(String key) {
		return studioInfoRepository.getAllByKey(key);
    }
}
