package com.lwl.json.quiz;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quiz {

		private String title;
		private List<QuizQuestion> questions;
		
		
}
