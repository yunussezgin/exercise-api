package com.yunus.exerciseapi.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.yunus.exerciseapi.dto.ExerciseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileParser {

    public List<ExerciseDTO> parseExercisesFromCsvFile(MultipartFile csvFile) throws IOException {
        List<ExerciseDTO> exerciseDtoList = new ArrayList<>();
        Reader reader = new InputStreamReader(csvFile.getInputStream());

        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] columns = csvReader.readNext();

            while ((columns = csvReader.readNext()) != null) {
                ExerciseDTO exerciseDto = ExerciseDTO.builder()
                        .source(columns[0])
                        .codeListCode(columns[1])
                        .code(columns[2])
                        .displayValue(columns[3])
                        .longDescription(columns[4])
                        .fromDate(CommonUtils.parseStringToLocalDateTime(columns[5]))
                        .toDate(CommonUtils.parseStringToLocalDateTime(columns[6]))
                        .sortingPriority(CommonUtils.parseStringToInteger(columns[7]))
                        .build();
                exerciseDtoList.add(exerciseDto);
            }
        } catch (CsvValidationException e) {
            // TODO Custom exception
        }

        return exerciseDtoList;
    }

}
