package com.arcade.gamon.Service.impl;

import com.arcade.gamon.Service.mapper.StudentMapper;
import com.arcade.gamon.domin.dto.StudentDto;
import com.arcade.gamon.domin.dto.StudentResponseDto;
import com.arcade.gamon.domin.entity.Student;
import com.arcade.gamon.repository.StudentRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    // Test target class
    @InjectMocks
    private StudentServiceImpl studentService;
    //Dependencies
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository studentRepository;


    // ================= REGISTER NEW STUDENT TEST =========================
    @Test
    @Disabled("This test passed !")
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

        //Mock & Stub
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponseDto(student)).thenReturn(new StudentResponseDto(
                "SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com"
        ));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        //Verify
        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentMapper, times(1)).toStudentResponseDto(student);
        verify(studentRepository, times(1)).save(student);
    }

    // ================= GET ALL THE STUDENTS TEST ========================
    @Test
    @DisplayName("getAll() test method")
    @Disabled("This test passed !")
    void getAll_method_should_return_all_students() {
        //GIVEN
        List<Student> students = new ArrayList<>();
        students.add(new Student("SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com",
                2));

        //STUB
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com"
        ));

        //WHEN
        List<StudentResponseDto> response = studentService.getAll();


        //Assertions
        assertEquals(students.size(), response.size());
        assertEquals(students.getFirst().getFirstName(), response.getFirst().firstName());


        //Verify
        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(1)).toStudentResponseDto(any(Student.class));
    }

    // =================== GET STUDENT BY ID TEST ==========================
    @Test
    @DisplayName("if a user id is present it should be returned and converted into StudentResponseDto")
    void student_by_present_id_should_be_founded() {
        //Given
        Integer id = 1;
        Student student = new Student("Alex", "Lion", "AfricanAleki@gmail.com", 5);


        //Stub
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(new StudentResponseDto(
                "Alex", "Lion", "AfricanAleki@gmail.com"
        ));

        //When
        StudentResponseDto dto = studentService.getById(id);

        //assertions
        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getLastName(), dto.lastName());
        assertEquals(student.getEmail(), dto.email());

        //Verify
        verify(studentRepository, times(1)).findById(id);
        verify(studentMapper, times(1)).toStudentResponseDto(student);
    }

    // =================== GET STUDENTS BY NAME TEST ========================
    @Test
    @DisplayName("if a user name or similar is present it should be returned and converted into list of StudentResponseDto's")
    void student_by_present_name_should_be_founded() {
        //Given
        String name = "SpongeBob";
        List<Student> students = new ArrayList<>();
        students.add(new Student("SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com",
                2));

        //Stub
        when(studentRepository.findByFirstNameContainingIgnoreCase(name)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "SpongeBob",
                "Square Pants",
                "krasytBob@gamil.com"
        ));

        //When
        List<StudentResponseDto> responseDto = studentService.getStudentsByFirstName(name);

        //Assertions (testing)
        assertEquals(students.size(), responseDto.size());
        assertEquals(students.getFirst().getFirstName(), responseDto.getFirst().firstName());

        //Verify
        verify(studentRepository, times(1)).findByFirstNameContainingIgnoreCase(name);
        verify(studentMapper, times(1)).toStudentResponseDto(any(Student.class));
    }
}