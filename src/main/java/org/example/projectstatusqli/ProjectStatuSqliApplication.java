package org.example.projectstatusqli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjectStatuSqliApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectStatuSqliApplication.class, args);
    }

}
