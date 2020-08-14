package com.lwl.json.quiz;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderUtil {

	private String fileName = "/quiz.json";

	public Quiz loadQuizFromJSONFile() {
		Quiz quiz = null;

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			quiz = objectMapper.readValue(JsonReaderUtil.class.getResourceAsStream(fileName), Quiz.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return quiz;
	}
}
