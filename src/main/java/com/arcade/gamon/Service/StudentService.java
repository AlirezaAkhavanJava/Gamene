package com.arcade.gamon.Service;

import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto saveStudent(StudentDto studentDto);

    List<StudentResponseDto> getAll();

    StudentResponseDto getById(int id);

    List<StudentResponseDto> getStudentsByFirstName(String firstName);

    void removeStudentById(Integer id);
}
