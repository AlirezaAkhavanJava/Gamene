package com.arcade.gamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class GamonApplication {
    static void main(String[] args) {
        SpringApplication.run(GamonApplication.class, args);
    }
}
