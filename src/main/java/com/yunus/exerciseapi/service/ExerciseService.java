package com.yunus.exerciseapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExerciseService {

    void uploadExercisesByCsvFile(MultipartFile csvFile) throws Exception;

}
