package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	List<Album> findAllByStudioInfo(StudioInfo studioInfo);

	List<Album> findAllByPhotographerInfo(PhotographerInfo photographerInfo);

	List<Album> findAllByStatus(int status);
}
