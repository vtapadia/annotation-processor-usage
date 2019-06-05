package com.github.vtapadia.examples.annotation.processor.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Employee {
    @Id
    private Long id;
    private String name;
    private String company;
    private int age;
}
