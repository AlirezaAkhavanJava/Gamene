package com.arcade.gamon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:favorite.properties"),
        @PropertySource("classpath:custom.properties")
})
public class UnitedStates {

    //NEEDS AN OBJECT OF THE FIRST CLASS
    private final FirstClass firstClass;
    private final Environment  environment;

    @Value("${author}")
    private String writer;
    @Value("${movie}")
    private String favoriteMovie;

    @Autowired
    public UnitedStates(@Qualifier("Bush") FirstClass firstClass, Environment environment) {
        this.firstClass = firstClass;
        this.environment = environment;
    }


    public String whatToDo() {
        return "Welcome to the United States University\n" + firstClass.trump() +
                "\nJava : " + environment.getProperty("java.version") + " Os : " +  environment.getProperty("os.name")
                + " \n" + environment.getProperty("is.linux")
                + " \n" + writer + " movie " +  favoriteMovie;
    }
}

