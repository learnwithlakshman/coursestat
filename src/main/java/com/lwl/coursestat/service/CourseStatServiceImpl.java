package com.lwl.coursestat.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.lwl.coursestat.domain.Student;
import com.lwl.coursestat.dto.CountDTO;
import com.lwl.coursestat.util.CsvReaderUtil;

public class CourseStatServiceImpl implements CourseStatService {

	private List<Student> studentList;

	public CourseStatServiceImpl(String fileName) {
		studentList = CsvReaderUtil.readDataFromFile(fileName);
	}

	@Override
	public List<Student> getStudentsByQualification(String qualification) {

		if (studentList != null) {
			return studentList.stream().filter(s -> s.getQualification().equals(qualification))
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public long getStudentCountByQualification(String qualification) {

		/*
		 * int count = 0; for (int i = 0; i < studentList.size(); i++) { Student stu =
		 * studentList.get(i); if
		 * (stu.getQualification().equalsIgnoreCase(qualification)) { count++; } }
		 * 
		 * return count;
		 */

		return studentList.stream().filter(e -> e.getQualification().equalsIgnoreCase(qualification)).count();
	}

	@Override
	public long getPlacedStudentCount() {
		return studentList.stream().filter(ele -> ele.getPstatus().equals("Y")).count();
	}

	@Override
	public long getNotPlacedStudentCount() {
		return studentList.stream().filter(ele -> ele.getPstatus().equals("N")).count();
	}

	@Override
	public CountDTO getPlacedAndNotPlacedCount() {
		int placed = (int)getPlacedStudentCount();
		int notplaced = studentList.size() - placed;
		return CountDTO.builder().placedCount(placed).notPlacedCount(notplaced).build();
	}

	@Override
	public List<Student> search(String str) {
		return studentList.stream().filter(e->e.getName().toLowerCase().contains(str.toLowerCase())).collect(Collectors.toList());
	}

	@Override
	public float successRate(String batchName) {
		return 0;
	}

	@Override
	public List<Student> maxScoreStudent() {
		return null;
	}

	@Override
	public List<String> getStudentNames() {
		return studentList.stream().map(s -> s.getName()).collect(Collectors.toList());
	}

}
