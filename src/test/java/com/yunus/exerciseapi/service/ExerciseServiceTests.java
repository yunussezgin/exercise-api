package com.yunus.exerciseapi.service;

import com.yunus.exerciseapi.entity.Exercise;
import com.yunus.exerciseapi.repository.ExerciseRepository;
import com.yunus.exerciseapi.util.FileParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestDataBuilder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTests {

    @Mock
    private ExerciseRepository exerciseRepository;

    @Mock
    private FileParser fileParser;

    @InjectMocks
    private ExerciseServiceImpl exerciseService;

    @Captor
    ArgumentCaptor<List<Exercise>> exerciseCaptor;

    @Test
    public void givenCsvFile_whenUploadCsvFile_thenCreateExercisesSuccessfully() throws Exception {
        // given
        given(fileParser.parseExercisesFromCsvFile(any())).willReturn(TestDataBuilder.generateExerciseDTOListSuccess());

        // when
        exerciseService.uploadExercisesByCsvFile(any());
        Mockito.verify(exerciseRepository).saveAll(exerciseCaptor.capture());
        List<Exercise> exerciseList = exerciseCaptor.getValue();

        // then
        assertThat(exerciseList.size()).isEqualTo(2);
        assertThat(exerciseList.get(0).getCode()).isNotNull();
        assertThat(exerciseList.get(1).getCode()).isNotNull();
    }

    @Test
    public void givenCsvFile_whenGetExerciseByCode_thenReturnExerciseSuccessfully()  {
        // given
        given(exerciseRepository.findByCode("271636001")).willReturn(Optional.of(TestDataBuilder.generateExerciseSuccess()));

        // when
        Exercise exercise = exerciseService.getExerciseByCode("271636001");

        // then
        assertThat(exercise.getCode()).isEqualTo("271636001");
    }

    @Test
    public void givenCsvFile_whenGetAllExercises_thenReturnExercisesSuccessfully()  {
        // given
        given(exerciseRepository.findAll()).willReturn(TestDataBuilder.generateExerciseListSuccess());

        // when
        List<Exercise> exerciseList = exerciseService.getAllExercises();

        // then
        assertThat(exerciseList.size()).isEqualTo(2);
        assertThat(exerciseList.get(0).getCode()).isNotNull();
        assertThat(exerciseList.get(1).getCode()).isNotNull();
    }

}
