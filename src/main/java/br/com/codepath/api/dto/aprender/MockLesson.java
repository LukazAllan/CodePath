package br.com.codepath.api.dto.aprender;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MockLesson{
    private String name;
    private String content;
    private MockProgress progress;
}
