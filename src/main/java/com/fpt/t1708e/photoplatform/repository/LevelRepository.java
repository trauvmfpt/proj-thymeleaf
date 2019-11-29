package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface LevelRepository extends JpaRepository<Level,Long> {
    List<Level> getLevelByStatus(int status);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table level AUTO_INCREMENT = 1")
    void resetIncrement();
}
