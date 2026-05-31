package br.com.codepath.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SectionDTO{
    private String title;
    private String subtitle;
    private String color;
    private String icon;
    private Integer ordem;
}