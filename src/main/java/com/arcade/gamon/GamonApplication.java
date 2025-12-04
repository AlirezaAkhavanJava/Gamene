package com.arcade.gamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamonApplication {
    static void main(String[] args) {

        var context = SpringApplication.run(GamonApplication.class, args);

        FirstClass fc = context.getBean("trumpChina" , FirstClass.class);
        System.out.println(System.lineSeparator());
        System.out.println("====================" + fc.trump() + "====================");


        UnitedStates unitedStates = context.getBean(UnitedStates.class);
        System.out.println(unitedStates.whatToDo());
    }



}
