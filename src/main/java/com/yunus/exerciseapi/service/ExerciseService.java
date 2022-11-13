package com.yunus.exerciseapi.service;

import com.yunus.exerciseapi.entity.Exercise;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExerciseService {

    void uploadExercisesByCsvFile(MultipartFile csvFile) throws Exception;

    List<Exercise> getAllExercises();

    Exercise getExerciseByCode(String code);

    void deleteAllExercises();

}
