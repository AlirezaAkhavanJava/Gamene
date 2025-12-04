package com.arcade.gamon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstClass {


    @Bean
    public String trump() {
        return "china ! chian china !!";
    }
}
