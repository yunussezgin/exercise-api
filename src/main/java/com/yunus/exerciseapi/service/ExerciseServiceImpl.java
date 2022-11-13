package com.yunus.exerciseapi.service;

import com.yunus.exerciseapi.entity.Exercise;
import com.yunus.exerciseapi.exception.NotFoundException;
import com.yunus.exerciseapi.repository.ExerciseRepository;
import com.yunus.exerciseapi.util.Constants;
import com.yunus.exerciseapi.util.FileParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final FileParser dataParser;

    private final ExerciseRepository exerciseRepository;

    @Override
    public void uploadExercisesByCsvFile(MultipartFile csvFile) throws Exception {
        List<Exercise> exerciseList = new ArrayList<>();

        dataParser.parseExercisesFromCsvFile(csvFile).forEach(exerciseDto -> {
            Exercise exercise = new Exercise();
            BeanUtils.copyProperties(exerciseDto, exercise);
            exerciseList.add(exercise);
        });

        exerciseRepository.saveAll(exerciseList);
    }

    @Override
    public List<Exercise> getAllExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseRepository.findAll().forEach(exerciseList::add);
        return exerciseList;
    }

    @Override
    public Exercise getExerciseByCode(String code) {
        return exerciseRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.NOT_FOUND_EXCEPTION_MESSAGE, code)));
    }

    @Override
    public void deleteAllExercises() {
        exerciseRepository.deleteAll();
    }
}
