package com.example.testing_aop_proxy.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Builder
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String method;

    private String requestId;

    private long duration;

    private long created;
}
