package com.arcade.gamon.Service.impl;

import com.arcade.gamon.Service.StudentService;
import com.arcade.gamon.Service.mapper.StudentMapper;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.Student;
import com.arcade.gamon.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;


class StudentServiceImplTest {

    // Test target class
    @InjectMocks
    private StudentService studentService;

    //Dependencies
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void should_save_student() {
        //Given
        StudentDto dto = new StudentDto("SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com",
                2);

        Student student = new Student("SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com",
                2);

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());
    }

}