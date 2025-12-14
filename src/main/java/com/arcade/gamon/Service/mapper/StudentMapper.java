package com.arcade.gamon.Service.mapper;

import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.School;
import com.arcade.gamon.domin.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    // ******* Maps student dto to the Student Entity *********
    public Student toStudent(StudentDto dto) {

        if (dto == null) {
            throw new NullPointerException("Student DTO can not be null");
        }

        return Student.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .school(School.builder()
                        .id(dto.schoolId())
                        .build())
                .build();
    }

    // ******* Maps student object(entity) to the StudentResponseDto *********
    // =========StudentResponseDto is the Response that is sent back to the client==========
    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(), student.getLastName(), student.getEmail()
        );
    }
}
