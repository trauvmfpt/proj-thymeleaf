package com.fpt.t1708e.photoplatform.dto;

import java.time.LocalDate;

public class RevenueDTO {
    private double revenue;
    private LocalDate day;

    public RevenueDTO() {
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
