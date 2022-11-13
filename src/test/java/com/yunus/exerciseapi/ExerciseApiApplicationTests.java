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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
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

}
