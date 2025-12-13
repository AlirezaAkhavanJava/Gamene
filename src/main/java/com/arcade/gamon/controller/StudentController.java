package com.arcade.gamon.controller;

import com.arcade.gamon.Service.StudentService;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping("public/new")
    public StudentResponseDto save(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("private/all")
    public List<StudentResponseDto> findAll() {
        return studentService.getAll();
    }

    @GetMapping("/private/id/{id}")
    public StudentResponseDto findById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping("private/{name}")
    public List<StudentResponseDto> findByFirstNameContainingIgnoreCase(@PathVariable("name") String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @DeleteMapping("private/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        studentService.removeStudentById(id);
    }


}
