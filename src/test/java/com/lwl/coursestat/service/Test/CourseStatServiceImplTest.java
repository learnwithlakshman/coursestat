package com.lwl.coursestat.service.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lwl.coursestat.domain.Student;
import com.lwl.coursestat.dto.CountDTO;
import com.lwl.coursestat.service.CourseStatService;
import com.lwl.coursestat.service.CourseStatServiceImpl;

public class CourseStatServiceImplTest {

	private final String fileName = "/coursedata.csv";

	@Test
	public void getStudentByQualificationMtech() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		String qualification = "M.Tech";
		List<Student> list = obj.getStudentsByQualification(qualification);
		assertEquals(2, list.size());

	}

	@Test
	public void getStudentByQualificationMBA() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		String qualification = "MBA";
		List<Student> list = obj.getStudentsByQualification(qualification);
		assertEquals(0, list.size());
	}

	@Test
	public void getStudentNamesTest() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		List<String> names = obj.getStudentNames();
		assertEquals(15, names.size());
	}

	@Test
	public void getPlacedStudentCountTest() {
		CourseStatService obj = new CourseStatServiceImpl(fileName);
		long actualCount = obj.getPlacedStudentCount();
		long expectedCount = 6;
		assertEquals(expectedCount, actualCount);
	}

	@Test
	void getStudentCountByQualificationTest() {
		CourseStatService service = new CourseStatServiceImpl(fileName);
		String qualification = "MCA";

		long actual = service.getStudentCountByQualification(qualification);
		long expected = 2;

		assertEquals(expected, actual);
	}

	@Test
	void getNotPlacedStudentCountTest() {
		CourseStatService service = new CourseStatServiceImpl(fileName);
		long actual = service.getNotPlacedStudentCount();
		long expected = 9;
		assertEquals(expected, actual);

	}
	
	@Test
	void getPlacedAndNotPlacedCountTest() {
		CourseStatService service = new CourseStatServiceImpl(fileName);
		CountDTO dto = service.getPlacedAndNotPlacedCount();
		
		assertEquals(dto.getPlacedCount(), 6);
		assertEquals(dto.getNotPlacedCount(), 9);
	}
	
	@Test
	void searchTest() {
		CourseStatService service = new CourseStatServiceImpl(fileName);
		List<Student> list = service.search("son");
		list.stream().forEach(e->{
			System.out.println(e.getName());
		});
		assertEquals(list.size(), 2);
	}
}
