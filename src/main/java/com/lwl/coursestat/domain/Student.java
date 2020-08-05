package com.lwl.coursestat.domain;

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
public class Student {

	private String name;
	private String cstatus;
	private String pstatus;
	private String batch;
	private String qualification;
	private float score;
}
