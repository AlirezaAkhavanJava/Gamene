package com.arcade.gamon.controller;

import com.arcade.gamon.Service.StudentService;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/students/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // ================= REGISTER NEW STUDENT=========================
    @PostMapping("public/new")
    public StudentResponseDto save(@Valid @RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    // ================= GET ALL THE STUDENTS ========================
    @GetMapping("private/all")
    public List<StudentResponseDto> findAll() {
        return studentService.getAll();
    }

    // =================== GET STUDENT BY ID ==========================
    @GetMapping("/private/id/{id}")
    public StudentResponseDto findById(@PathVariable int id) {
        return studentService.getById(id);
    }

    // =================== GET STUDENTS BY NAME ========================
    @GetMapping("private/{name}")
    public List<StudentResponseDto> findByFirstNameContainingIgnoreCase(@PathVariable("name") String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    // =================== REMOVE STUDENT BY ID =======================
    @DeleteMapping("private/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        studentService.removeStudentById(id);
    }

    // =================== VALIDATION HANDLER =======================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            var filedName = ((FieldError) error).getField();
            var message = error.getDefaultMessage();
            errors.put(filedName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
