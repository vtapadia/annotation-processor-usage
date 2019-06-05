package com.github.vtapadia.examples.annotation.processor.web;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String company;
    private int age;
}
