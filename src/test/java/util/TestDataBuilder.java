package util;

import com.yunus.exerciseapi.dto.ExerciseDTO;
import com.yunus.exerciseapi.entity.Exercise;

import java.time.LocalDate;
import java.util.List;

public class TestDataBuilder {

    public static List<ExerciseDTO> generateExerciseDTOListSuccess() {
        return List.of(ExerciseDTO.builder()
                        .source("ZIB")
                        .codeListCode("ZIB001")
                        .code("271636001")
                        .displayValue("Polsslag regelmatig")
                        .longDescription("The long description is necessary")
                        .fromDate(LocalDate.now())
                        .toDate(LocalDate.now())
                        .sortingPriority(1)
                        .build(),
                ExerciseDTO.builder()
                        .source("ZIB")
                        .codeListCode("ZIB001")
                        .code("61086009")
                        .displayValue("Polsslag regelmatig")
                        .longDescription("")
                        .fromDate(LocalDate.now())
                        .toDate(null)
                        .sortingPriority(2)
                        .build());
    }

    public static Exercise generateExerciseSuccess() {
        return Exercise.builder()
                .id("8c85dffb-bb6d-454f-890b-936b69bb9ff6")
                .source("ZIB")
                .codeListCode("ZIB001")
                .code("271636001")
                .displayValue("Polsslag regelmatig")
                .longDescription("The long description is necessary")
                .fromDate(LocalDate.now())
                .toDate(LocalDate.now())
                .sortingPriority(1)
                .build();
    }

    public static List<Exercise> generateExerciseListSuccess() {
        return List.of(Exercise.builder()
                        .id("8c85dffb-bb6d-454f-890b-936b69bb9ff6")
                        .source("ZIB")
                        .codeListCode("ZIB001")
                        .code("271636001")
                        .displayValue("Polsslag regelmatig")
                        .longDescription("The long description is necessary")
                        .fromDate(LocalDate.now())
                        .toDate(LocalDate.now())
                        .sortingPriority(1)
                        .build(),
                Exercise.builder()
                        .id("25656d10-d77a-4ef2-afd0-738360034e65")
                        .source("ZIB")
                        .codeListCode("ZIB001")
                        .code("61086009")
                        .displayValue("Polsslag onregelmatig")
                        .longDescription("")
                        .fromDate(LocalDate.now())
                        .toDate(null)
                        .sortingPriority(2)
                        .build());
    }
}
