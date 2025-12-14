package com.arcade.gamon.Service.impl;

import com.arcade.gamon.Service.StudentService;
import com.arcade.gamon.Service.mapper.StudentMapper;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    // ================= REGISTER NEW STUDENT=========================
    @Override
    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = mapper.toStudent(studentDto);
        var saved = studentRepository.save(student);
        return mapper.toStudentResponseDto(saved);
    }

    // ================= GET ALL THE STUDENTS ========================
    @Override
    public List<StudentResponseDto> getAll() {
        return studentRepository.findAll().stream()
                .map(mapper::toStudentResponseDto)
                .toList();
    }

    // =================== GET STUDENT BY ID ==========================
    @Override
    public StudentResponseDto getById(int id) {
        return studentRepository.findById(id)
                .map(mapper::toStudentResponseDto)
                .orElse(null);

    }

    // =================== GET STUDENTS BY NAME ========================
    @Override
    public List<StudentResponseDto> getStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName).stream()
                .map(mapper::toStudentResponseDto)
                .toList();
    }

    // =================== REMOVE STUDENT BY ID =======================
    @Override
    public void removeStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
