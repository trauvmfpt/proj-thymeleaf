package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudioInfoRepository extends JpaRepository<StudioInfo, Long> {
    @Query(nativeQuery = true,value = "select * FROM studio_info where full_name like %:key% order by full_name desc limit 5")
    List<StudioInfo> getTop5(@Param("key") String key);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table studio_info AUTO_INCREMENT = 1")
    void resetIncrement();
    @Query(nativeQuery = true,value = "select * FROM studio_info order by average_rate desc limit 10")
    List<StudioInfo> getTop10Rating();
    StudioInfo findByAccount_Id(long accountId);
}
