package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudioInfoRepository extends JpaRepository<StudioInfo, Long> {
    @Query(nativeQuery = true,value = "select * FROM studio_info where full_name like %:key% order by full_name desc limit 5")
    List<StudioInfo> getTop5(@Param("key") String key);
}
