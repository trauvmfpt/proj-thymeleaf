package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;
    private String fullName;
    private String address;
    private int gender;
    private long birthday;
    private String phone;
    private String email;
    @Column(columnDefinition = "text")
    private String description;
    private String avatar;
    private long levelExpiredAt;

}
