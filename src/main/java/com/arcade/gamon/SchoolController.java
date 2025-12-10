package com.arcade.gamon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @PostMapping("/save")
    private School saveSchool(School school) {
        return schoolRepository.save(school);
    }
}
