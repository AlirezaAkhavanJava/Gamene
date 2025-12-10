package com.arcade.gamon;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @PostMapping("public/new")
    public String save(@RequestBody Student student) {
        studentRepository.save(student);
        return "success";
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
