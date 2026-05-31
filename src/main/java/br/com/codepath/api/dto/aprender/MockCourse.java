package br.com.codepath.api.dto.aprender;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class MockCourse{
    private String courseName;
    private List<MockSection> sections;
}