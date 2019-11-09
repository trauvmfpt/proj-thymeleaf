package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;
    private float discount;
    @Column(columnDefinition = "text")
    private String description;
    private int status;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
}
