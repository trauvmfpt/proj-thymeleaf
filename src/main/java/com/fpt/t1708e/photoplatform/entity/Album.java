package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    private String name;
    private String description;
    private String thumbnail;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> productSet;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rating> ratingSet;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> commentSet;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

}
