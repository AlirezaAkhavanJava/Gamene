package com.arcade.gamon.controller;

import com.arcade.gamon.domin.dto.SchoolDto;
import com.arcade.gamon.repository.SchoolRepository;
import com.arcade.gamon.domin.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {
    private School toSchool(SchoolDto schoolDto) {
        return School.builder()
                .name(schoolDto.name())
                .build();
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    private final SchoolRepository schoolRepository;

    @PostMapping("/save")
    private SchoolDto saveSchool(@RequestBody SchoolDto schoolDto) {
        var school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }


    @GetMapping("/all")
    private List<SchoolDto> schools() {
        return schoolRepository.findAll().stream()
                .map(this::toSchoolDto)
                .toList();
    }
}
