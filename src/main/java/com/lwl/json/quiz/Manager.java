package com.lwl.json.quiz;

public class Manager {

		public static void main(String[] args) {
			
				QuizService service = new QuizService();
				try {
					service.startQuiz();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
}
