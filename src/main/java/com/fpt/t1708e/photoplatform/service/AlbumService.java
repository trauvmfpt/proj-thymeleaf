package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
	@Autowired
	AlbumRepository albumRepository;

	public List<Album> albumsByStudio(StudioInfo studioInfo) {
		return albumRepository.findAllByStudioInfo(studioInfo);
	}

	public Album albumById(long id) {
		return albumRepository.findById(id).orElse(null);
	}

	public Album create(Album album) {
		return albumRepository.save(album);
	}

	public List<Album> albumsByPhotographer(PhotographerInfo photographerInfo) {
		return albumRepository.findAllByPhotographerInfo(photographerInfo);
	}
}
