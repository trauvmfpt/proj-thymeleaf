package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.AdminRevenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AdminRevenueRepository extends JpaRepository<AdminRevenue, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table admin_revenue AUTO_INCREMENT = 1")
    void resetIncrement();
}
