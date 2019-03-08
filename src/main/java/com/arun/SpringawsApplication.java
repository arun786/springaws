package com.arun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringawsApplication extends SpringBootServletInitializer {

    /*
     * To create a war file
     * step 1 Extends SpringBootServletInitializer
     * step 2 override the configure method
     * step 3 change the jar file to war file in pom
     */

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringawsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringawsApplication.class, args);
    }

}
