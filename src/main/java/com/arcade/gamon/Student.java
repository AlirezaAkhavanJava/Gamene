package com.arcade.gamon;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "st_name", length = 30, nullable = false)
    private String firstName;
    private String lastName;
    @Column(length = 130, nullable = false , unique = true)
    private String email;
    private int age;
}
