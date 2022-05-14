package com.thesidproject.ttr.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
@EntityScan("com.*")
@ServletComponentScan("com.*")
public class TicketToRideApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(TicketToRideApplication.class);

    @Value("${appName}")
    private String appName;

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    public static void main(String[] args) {
        SpringApplication.run(TicketToRideApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            logger.info("************* APP NAME           *** " + appName);
            logger.info("************* ACTIVE PROFILES    *** " + activeProfiles);
        };
    }
}