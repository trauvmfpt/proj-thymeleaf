package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String url;
    private int status;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
}
