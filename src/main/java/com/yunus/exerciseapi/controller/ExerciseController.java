package com.yunus.exerciseapi.controller;

import com.yunus.exerciseapi.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("/uploadCsvFile")
    public ResponseEntity<Void> uploadExercisesByCsvFile(@RequestParam("csvFile") MultipartFile csvFile) throws Exception {
        exerciseService.uploadExercisesByCsvFile(csvFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
