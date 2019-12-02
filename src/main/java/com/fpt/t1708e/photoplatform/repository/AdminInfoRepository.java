package com.fpt.t1708e.photoplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.t1708e.photoplatform.entity.AdminInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table admin_info AUTO_INCREMENT = 1")
    void resetIncrement();
}
