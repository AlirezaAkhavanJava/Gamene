package com.arcade.gamon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UnitedStates {

    private final FirstClass firstClass;

    @Autowired
    public UnitedStates(@Qualifier("Bush") FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public String whatToDo() {
        return "Trump the president of the united states of America is going to : " + firstClass.trump();
    }
}
