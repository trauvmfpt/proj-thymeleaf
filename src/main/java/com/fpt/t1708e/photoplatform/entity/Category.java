package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String thumbnail;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> productSet;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
}
