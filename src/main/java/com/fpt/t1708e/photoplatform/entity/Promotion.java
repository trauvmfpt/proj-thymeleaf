package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    private String name;
    private String description;
    private float discount;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
}
