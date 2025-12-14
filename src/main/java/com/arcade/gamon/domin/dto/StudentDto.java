package com.arcade.gamon.domin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StudentDto(
        @NotNull
        @NotEmpty(message = "Firstname can not be empty !")
        String firstName,

        @NotNull
        @NotEmpty(message = "Lastname is Required !")
        String lastName,

        String email,

        Integer schoolId
) {
}
