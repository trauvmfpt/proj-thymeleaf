package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c where c.album.id = :id or c.product.id = :id or c.studioInfo.id = :id or c.photographerInfo.id = :id")
    List<Comment> findByPostId(long id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table comment AUTO_INCREMENT = 1")
    void resetIncrement();
}
