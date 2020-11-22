package com.example.testing_aop_proxy.entity

import javax.persistence.*

@Entity
data class Statistic(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long = 0,

        @Column(nullable = false)
        private val packageName: String,

        @Column(nullable = false)
        private val method: String,

        private val duration: Long = 0,
        private val created: Long = 0
)