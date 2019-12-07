package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    public List<Level> getList(){return levelRepository.getLevelByStatus(1);}
    public Level getById(long id) {
        return levelRepository.findById(id).orElse(null);
    }
    public Level create(Level level) {
        return levelRepository.save(level);
    }

    public Level update(Level level) {
        level.setUpdatedAt(LocalDate.now());
        return levelRepository.save(level);
    }
}
