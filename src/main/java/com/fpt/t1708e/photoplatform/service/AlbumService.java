package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public List<Album> albumsByAccount(Account account) {
        return albumRepository.findAllByAccount(account);
    }
    public Album albumById(long id) {
        return albumRepository.findById(id).orElse(null);
    }
    public Album create(Album album) {
        return albumRepository.save(album);
    }
}
