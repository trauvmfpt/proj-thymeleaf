package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
