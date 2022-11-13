package com.yunus.exerciseapi.controller;

import com.yunus.exerciseapi.entity.Exercise;
import com.yunus.exerciseapi.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping("/{code}")
    public ResponseEntity<Exercise> getExerciseByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(exerciseService.getExerciseByCode(code));
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllExercises() {
        exerciseService.deleteAllExercises();
        return ResponseEntity.noContent().build();
    }

}
