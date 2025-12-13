package com.arcade.gamon.Service;

import com.arcade.gamon.domin.dto.SchoolDto;

import java.util.List;

public interface SchoolService {
    SchoolDto saveSchool(SchoolDto schoolDto);

    List<SchoolDto> getAll();
}
