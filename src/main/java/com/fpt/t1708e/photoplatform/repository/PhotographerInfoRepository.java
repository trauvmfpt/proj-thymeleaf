package com.fpt.t1708e.photoplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PhotographerInfoRepository extends JpaRepository<PhotographerInfo, Long> {
    //    @Query(value = "select  p FROM PhotographerInfo p where p.fullName like %:key% order by p.fullName desc")
//    List<PhotographerInfo> getTop5(@Param("key")String key);
    @Query(nativeQuery = true,value = "select * FROM photographer_info where full_name like %:key% order by full_name desc limit 5")
    List<PhotographerInfo> getTop5(@Param("key") String key);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table photographer_info AUTO_INCREMENT = 1")
    void resetIncrement();

    PhotographerInfo findByAccount_Id(long accountId);
}
