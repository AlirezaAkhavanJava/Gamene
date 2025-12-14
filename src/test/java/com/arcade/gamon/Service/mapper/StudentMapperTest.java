package com.arcade.gamon.Service.mapper;

import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    @Disabled("This test is passed")
    public void shouldConvertStudentDTOToStudentEntity() {
        StudentDto dto = new StudentDto("SpongeBob", "Square Pants", "krasytBob@gamil.com", 2);
        Student student = studentMapper.toStudent(dto);
        assertAll(
                () -> assertEquals(dto.firstName(), student.getFirstName()),
                () -> assertEquals(dto.lastName(), student.getLastName()),
                () -> assertEquals(dto.email(), student.getEmail()),
                () -> assertNotNull(student.getSchool()),
                () -> assertEquals(dto.schoolId(), student.getSchool().getId())
        );
    }


    @Test
    @Disabled("This test is passed")
    public void shouldMapStudentToStudentDto() {
        Student jane = new Student("jane", "doe", "JaneIsDeadHere@gmail.com", 20);
        StudentResponseDto dto = studentMapper.toStudentResponseDto(jane);
        assertAll(
                () -> assertEquals(dto.firstName(), jane.getFirstName()),
                () -> assertEquals(dto.lastName(), jane.getLastName()),
                () -> assertEquals(dto.email(), jane.getEmail())
        );
    }


    @Test
    @Disabled("This test is passed")
    public void should_map_studentDto_to_student_when_StudentDto_is_null() {
        var exception = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("Student DTO can not be null", exception.getMessage());
    }

}