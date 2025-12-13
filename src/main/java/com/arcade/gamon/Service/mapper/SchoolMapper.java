package com.arcade.gamon.Service.mapper;

import com.arcade.gamon.domin.dto.SchoolDto;
import com.arcade.gamon.domin.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto schoolDto) {
        return School.builder()
                .name(schoolDto.name())
                .build();
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

}
