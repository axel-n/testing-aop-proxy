package com.example.testing_aop_proxy.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String requestId;

    private long duration;

    private long created = System.currentTimeMillis();
}
