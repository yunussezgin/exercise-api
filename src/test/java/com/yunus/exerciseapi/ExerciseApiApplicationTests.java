package com.yunus.exerciseapi;

import com.yunus.exerciseapi.repository.ExerciseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import util.TestConstants;
import util.TestUtils;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ExerciseApiApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ExerciseRepository exerciseRepository;

	@AfterEach
	void tearDown() {
		exerciseRepository.deleteAll();
	}
	@Test
	void givenCsvFile_whenUploadCsvFile_thenCreateExercisesSuccessfully() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_UPLOAD_SUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isCreated());
	}

	@Test
	void givenCsvFile_whenGetAllExercises_thenReturnAllExercisesSuccessfully() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_UPLOAD_SUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isCreated());

		mvc.perform(get(TestConstants.GET_ALL_EXERCISES_PATH))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(18)));
	}

	@Test
	void givenCsvFile_whenGetExerciseByCode_thenReturnExerciseSuccessfully() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_UPLOAD_SUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isCreated());

		mvc.perform(get(TestConstants.GET_EXERCISE_BY_CODE_PATH + "/271636001"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.code", is("271636001")))
				.andExpect(jsonPath("$.source", is("ZIB")))
				.andExpect(jsonPath("$.codeListCode", is("ZIB001")))
				.andExpect(jsonPath("$.displayValue", is("Polsslag regelmatig")))
				.andExpect(jsonPath("$.longDescription", is("The long description is necessary")))
				.andExpect(jsonPath("$.fromDate", is("01-01-2019")))
				.andExpect(jsonPath("$.toDate", is("01-02-2019")))
				.andExpect(jsonPath("$.sortingPriority", is(1)));
	}

	@Test
	void givenCsvFile_whenDeleteAllExercises_thenDeleteExercisesSuccessfully() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_UPLOAD_SUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isCreated());

		mvc.perform(delete(TestConstants.DELETE_ALL_EXERCISES_PATH))
				.andExpect(status().isNoContent());

		mvc.perform(get(TestConstants.GET_ALL_EXERCISES_PATH))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(0)));
	}

	@Test
	void givenCsvFile_whenCodeIsNotUnique_thenReturnInternalServerError() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_DUPLICATED_RECORD_UNSUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isInternalServerError());
	}

	@Test
	void givenCsvFile_whenDateFormatUnsupported_thenReturnBadRequestError() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_DATE_FORMAT_UNSUPPORTED_UNSUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.code", is("ERR400")))
				.andExpect(jsonPath("$.message", is("File reading error line:2. Text '2019-01-01' could not be parsed at index 2")));
	}

	@Test
	void givenCsvFile_whenSortingPriorityUnsupportedType_thenReturnBadRequestError() throws Exception {
		MockMultipartFile csvFile = TestUtils.generateCsvFileParam(TestConstants.CSV_FILE_EXERCISE_SORTING_PRIORITY_TYPE_UNSUPPORTED_UNSUCCESSFUL);

		mvc.perform(multipart(TestConstants.POST_UPLOAD_CSV_FILE_PATH).file(csvFile))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.code", is("ERR400")))
				.andExpect(jsonPath("$.message", is("File reading error line:1. For input string: \"one\"")));
	}

}
