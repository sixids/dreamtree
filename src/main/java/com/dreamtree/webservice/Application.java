package com.dreamtree.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/home/ec2-user/app/config/dreamtree-webservice/real-application.yml";
//            + "C:\\app\\config\\dreamtree-webservice\\real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
