package com.example.kafka.springbootkafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String dept;
    private Long salary;
}
