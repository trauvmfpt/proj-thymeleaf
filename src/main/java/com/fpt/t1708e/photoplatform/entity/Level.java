package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private float price;
    private long durationInDay;
    private int status;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
}
