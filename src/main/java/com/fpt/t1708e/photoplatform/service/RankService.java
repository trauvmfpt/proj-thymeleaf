package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Rank;
import com.fpt.t1708e.photoplatform.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class RankService {
    @Autowired
    RankRepository rankRepository;

    public List<Rank> getList(){return rankRepository.getRankByStatus(1);}
    public Rank getById(long id) {
        return rankRepository.findById(id).orElse(null);
    }
    public Rank create(Rank rank) {
        return rankRepository.save(rank);
    }
    public Rank update(Rank rank) {
        rank.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return rankRepository.save(rank);
    }
}
