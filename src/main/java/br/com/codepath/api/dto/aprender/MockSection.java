package br.com.codepath.api.dto.aprender;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class MockSection{
    private String title;
    private String subtitle;
    private String color;
    private String icon;
    private Integer ordem;
    private List<MockLesson> lessons;
}