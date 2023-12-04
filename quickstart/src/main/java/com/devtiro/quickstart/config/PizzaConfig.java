package com.devtiro.quickstart.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Configuration
@Component
@ConfigurationProperties(prefix = "pizza")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaConfig {
    private String crust;
    private String topping;
    private String sauce;
}
