package com.arcade.gamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamonApplication {
    static void main(String[] args) {

        var context = SpringApplication.run(GamonApplication.class, args);

        UnitedStates unitedStates = context.getBean(UnitedStates.class);
        System.out.println(unitedStates.whatToDo());
    }



}
