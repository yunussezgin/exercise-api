package com.yunus.exerciseapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ExerciseDTO {

    private String source;

    private String codeListCode;

    private String code;

    private String displayValue;

    private String longDescription;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Integer sortingPriority;
}
