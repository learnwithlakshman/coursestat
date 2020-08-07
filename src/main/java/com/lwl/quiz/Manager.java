package com.lwl.quiz;

public class Manager {

		public static void main(String[] args) throws InterruptedException {
			QuizService service = new QuizService();
			service.startQuiz();
		}
}
