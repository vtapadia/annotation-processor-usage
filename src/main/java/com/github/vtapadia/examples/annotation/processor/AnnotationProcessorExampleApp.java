package com.github.vtapadia.examples.annotation.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AnnotationProcessorExampleApp {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationProcessorExampleApp.class, args);
    }
}
