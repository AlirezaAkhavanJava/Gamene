package com.arcade.gamon.domin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "st_name", length = 30, nullable = false)
    private String firstName;
    private String lastName;
    @Column(length = 130, nullable = false, unique = true)
    private String email;
    private int age;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile profile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student(String jane, String doe, String mail, int age) {
        this.firstName = jane;
        this.lastName = doe;
        this.email = mail;
        this.age = age;
    }
}
