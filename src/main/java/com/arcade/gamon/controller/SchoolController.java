package com.arcade.gamon.controller;

import com.arcade.gamon.Service.SchoolService;
import com.arcade.gamon.domin.dto.SchoolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {


    private final SchoolService schoolService;


    @PostMapping("/save")
    private SchoolDto saveSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.saveSchool(schoolDto);
    }


    @GetMapping("/all")
    private List<SchoolDto> schools() {
        return schoolService.getAll();
    }
}
