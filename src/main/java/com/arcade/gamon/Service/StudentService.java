package com.arcade.gamon.Service;

import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDto saveStudent(StudentDto studentDto);

    List<Student> getAll();

    Student getById(int id);

    List<Student> getStudentByFirstName(String firstName);

    void removeStudentById(Integer id);
}
