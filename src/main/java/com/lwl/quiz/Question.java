package com.lwl.quiz;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {

		private int qid;
		private String questionData;
		private List<String> options;
		private int canswer;
		
}
