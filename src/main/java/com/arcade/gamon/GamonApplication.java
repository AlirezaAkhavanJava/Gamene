package com.arcade.gamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class GamonApplication {
    static void main(String[] args) {

//        var context = SpringApplication.run(GamonApplication.class, args);
//

        SpringApplication app = new SpringApplication(GamonApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
        ApplicationContext context = app.run(args);

        UnitedStates unitedStates = context.getBean(UnitedStates.class);
        System.out.println(unitedStates.whatToDo());

    }


}
