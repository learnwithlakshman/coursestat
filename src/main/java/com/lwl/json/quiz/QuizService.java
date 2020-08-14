package com.lwl.json.quiz;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuizService {

	private Quiz quiz;

	public QuizService() {
		JsonReaderUtil util = new JsonReaderUtil();
		quiz = util.loadQuizFromJSONFile();
	}

	public void startQuiz() throws InterruptedException {

		if (quiz != null) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("The quiz \"" + quiz.getTitle() + "\" is going start in few seconds");
				System.out.println("------------------------------------------------------");
				TimeUnit.SECONDS.sleep(2);

				List<QuizQuestion> questions = quiz.getQuestions();

				int i = 1,c=0,w=0;
				for (QuizQuestion question : questions) {

					System.out.println(i++ + ". " + question.getQuestion() + "\n");

					for (String option : question.getOptions()) {
						System.out.println(option);
					}
					System.out.println("\n");
					String choice = sc.nextLine();
					if(choice.equalsIgnoreCase(question.getAnswer())) {
						c++;
					}else {
						w++;
					}
				}
				showResult(questions.size(),c,w);
			}
		}
	}

	private void showResult(int size, int c, int w) throws InterruptedException {
		System.out.println("The results will be shown in few seconds please wait.....");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Total Questions       : "+size);
		System.out.println("No of Correct answers : "+c);
		System.out.println("No of Wrong answers   : "+w);
		
		String result = c/(float)size*100 > 40 ?"PASS":"FAIL";
		System.out.println("The final result is   :"+result);
		
		
	}

}
