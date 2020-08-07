package com.lwl.quiz;

import java.util.List;

public class QuizService {

	private List<Question> questions;
	private static String fileName = "/Task-2/quiz.txt";

	public QuizService() {
		questions = QuestionReaderUtil.loadQuestionFromFile(fileName);
	}

	public void startQuiz(){
		// Show question one by one
		// Prompt user input
		// Once done with all questions show the result
	}

	private void showResult(int size, int ccount, int wcount){
	
	}

}
