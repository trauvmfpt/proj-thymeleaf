package com.fpt.t1708e.photoplatform.service;

import java.util.List;

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
}
