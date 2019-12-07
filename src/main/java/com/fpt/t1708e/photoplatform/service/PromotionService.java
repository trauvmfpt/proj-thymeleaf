package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Promotion;
import com.fpt.t1708e.photoplatform.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionRepository promotionRepository;

    public List<Promotion> promotions() {
        return promotionRepository.findAll();
    }

    public Promotion create(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

	public Promotion getPromotionById(long id) {
		return promotionRepository.findById(id).orElse(null);
	}

    public Promotion update(Promotion promotion) {
        promotion.setUpdatedAt(LocalDate.now());
        return promotionRepository.save(promotion);
    }
}
