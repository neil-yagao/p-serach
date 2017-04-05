package com.neil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by nhu on 3/31/2017.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.neil")
public class MedicalMatching {

    public static void main(String[] args){
        SpringApplication.run(MedicalMatching.class,args);
    }

    /**for testing purpose and could be removed after real back end deployed*/
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("http://localhost:18080");
            }
        };
    }
}
