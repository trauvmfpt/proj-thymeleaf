package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	List<Album> findAllByStudioInfo(StudioInfo studioInfo);

	List<Album> findAllByPhotographerInfo(PhotographerInfo photographerInfo);

	List<Album> findAllByStatus(int status);
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "alter table album AUTO_INCREMENT = 1")
	void resetIncrement();
	@Query("SELECT c FROM Album c where c.name LIKE %:key% or c.description LIKE %:key%")
    List<Album> findALlByKey(@Param("key") String key);
	@Query(nativeQuery = true,value = "select * FROM album order by id desc limit 10")
    List<Album> getTopRate();
}
