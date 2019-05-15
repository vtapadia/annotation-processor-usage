package com.github.vtapadia.examples.annotation.processor.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "project")
public class Project {
    private String name;
    private String description;
    private String version;
}
