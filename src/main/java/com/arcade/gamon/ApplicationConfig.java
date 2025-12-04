package com.arcade.gamon;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean("trumpChina")
    @Primary
    public FirstClass firstClass() {
        return new FirstClass();
    }

    @Bean("Bush")
    @Qualifier("Bush")
    public FirstClass getFirstClass() {
        return new FirstClass("Lets attack DutchLand ! ");
    }

    @Bean
    public SomeClass getSomeClass() {
        return new SomeClass();
    }
}
