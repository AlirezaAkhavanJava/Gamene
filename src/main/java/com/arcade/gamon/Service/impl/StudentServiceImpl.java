package com.arcade.gamon.Service.impl;

import com.arcade.gamon.Service.mapper.StudentMapper;
import com.arcade.gamon.Service.StudentService;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.Student;
import com.arcade.gamon.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = mapper.toStudent(studentDto);
        var saved = studentRepository.save(student);
        return mapper.toStudentResponseDto(saved);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Override
    public void removeStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
