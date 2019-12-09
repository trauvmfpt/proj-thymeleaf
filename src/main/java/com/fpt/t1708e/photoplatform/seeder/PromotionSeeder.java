package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Promotion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PromotionSeeder {
    public static List<Promotion> promotionList = new ArrayList<>();

    public static void addPromotion() {
        Promotion promotion = new Promotion();
        promotion.setName("Discount X'Mas 10% all Product");
        promotion.setDescription("Jingle bells. Jingle bells. Jingle all the way. Oh, what fun. It is to ride. In a one-horse open sleigh. Repeat Chorus Dashing through the");
        promotion.setDiscount(10/100);
        promotion.setExpiredAt(TimeUnit.DAYS.toMillis(5));
        promotionList.add(promotion);
    }
}
