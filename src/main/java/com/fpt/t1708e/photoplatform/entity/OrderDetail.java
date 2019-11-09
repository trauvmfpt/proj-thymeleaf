package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "orderId")
    private Order order;
    private double currentPrice;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
}
