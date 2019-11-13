package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    public Level getById(long id) {
        return levelRepository.findById(id).orElse(null);
    }
    public Level create(Level level) {
        return levelRepository.save(level);
    }

    public Level update(Level level) {
        level.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return levelRepository.save(level);
    }
}
