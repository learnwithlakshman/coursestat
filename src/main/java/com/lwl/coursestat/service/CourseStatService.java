package com.lwl.coursestat.service;

import java.util.List;

import com.lwl.coursestat.domain.Student;
import com.lwl.coursestat.dto.CountDTO;

public interface CourseStatService {
	public List<Student> getStudentsByQualification(String qualification);

	public int getStudentCountByQualification(String qualification);

	public int getPlacedStudentCount();

	public int getNotPlacedStudentCount();

	public CountDTO getPlacedAndNotPlacedCount();

	public List<Student> search(String str);

	public float successRate(String batchName);

	public List<Student> maxScoreStudent();

	public List<String> getStudentNames();
}
