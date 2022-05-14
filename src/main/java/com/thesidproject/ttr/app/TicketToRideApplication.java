package com.thesidproject.ttr.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketToRideApplication {

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