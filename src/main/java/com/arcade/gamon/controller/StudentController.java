package com.arcade.gamon.controller;

import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.School;
import com.arcade.gamon.repository.StudentRepository;
import com.arcade.gamon.domin.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    public Student toStudent(StudentDto dto) {
        return Student.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .school(School.builder()
                        .id(dto.schoolId())
                        .build())
                .build();
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(), student.getLastName(), student.getEmail()
        );
    }


    @PostMapping("public/new")
    public StudentResponseDto save(@RequestBody StudentDto studentDto) {
        var student = toStudent(studentDto);
        var saved = studentRepository.save(student);
        return toStudentResponseDto(saved);
    }

    @GetMapping("private/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/private/id/{id}")
    public Student findById(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("private/{name}")
    public List<Student> findByFirstNameContainingIgnoreCase(@PathVariable("name") String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    @DeleteMapping("private/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }


}
