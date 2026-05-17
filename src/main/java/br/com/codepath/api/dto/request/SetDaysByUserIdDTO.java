package br.com.codepath.api.dto.request;

import lombok.Data;

@Data
public class SetDaysByUserIdDTO {
    private Long userId;
    private Integer days;
}
