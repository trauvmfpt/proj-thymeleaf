package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PictureRepository extends JpaRepository<Picture,Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table picture AUTO_INCREMENT = 1")
    void resetIncrement();
}
