package com.arcade.gamon.Service.impl;

import com.arcade.gamon.Service.SchoolService;
import com.arcade.gamon.Service.mapper.SchoolMapper;
import com.arcade.gamon.domin.dto.SchoolDto;
import com.arcade.gamon.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper mapper;

    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
        var school = mapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    @Override
    public List<SchoolDto> getAll() {
        return schoolRepository.findAll().stream()
                .map(mapper::toSchoolDto)
                .toList();
    }
}
