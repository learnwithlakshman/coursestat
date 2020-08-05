package com.lwl.coursestat.service.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lwl.coursestat.domain.Student;
import com.lwl.coursestat.service.CourseStatService;
import com.lwl.coursestat.service.CourseStatServiceImpl;

public class CourseStatServiceImplTest {

	private final String fileName = "/coursedata.csv";
	
	@Test
	public void getStudentByQualificationMtech() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		String qualification = "M.Tech";
		List<Student> list = obj.getStudentsByQualification(qualification);
		assertEquals(2,list.size());
		
	}
	@Test
	public void getStudentByQualificationMBA() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		String qualification = "MBA";
		List<Student> list = obj.getStudentsByQualification(qualification);
		assertEquals(0,list.size());
	}
}
