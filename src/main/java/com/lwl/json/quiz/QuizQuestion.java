package com.lwl.json.quiz;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizQuestion {

		private String question;
		private List<String> options;
		private String answer;
}
