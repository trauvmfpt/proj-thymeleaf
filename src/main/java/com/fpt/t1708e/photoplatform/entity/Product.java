package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "albumId")
    private Album album ;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String content;
    private double price;
    private double priceDiscount;
    private String area;
    private String destination;
    private String thumbnail;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rating> ratingSet;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> commentSet;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
}
