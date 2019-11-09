package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    private String customerPhone;
    private float totalPrice;
    private int paymentType;
    private String customerEmail;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetailSet;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
}
