package com.arcade.gamon;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig { /*Configuration class for the bean container ! */


    // CUSTOM BEAN CONTAINER

    @Bean("trumpChina")
    @Primary
    //BY THE PRIMARY ANNOTATION THIS TYPE WILL NEVER FACE A BEAN TYPE CONFLICT
    public FirstClass firstClass() {
        return new FirstClass();
    }

    // SECOND BEAN OF THE SAME TYPE TO MAKE A CONFLICT
    // ANNOTATED WITH QUALIFIER TO HANDLE THE CONFLICTS
    @Bean("Bush")
    @Qualifier("Bush")
    public FirstClass getFirstClass() {
        return new FirstClass("Lets attack DutchLand ! ");
    }

}
