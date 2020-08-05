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
		
		if(studentList != null) {
			return studentList.stream().filter(s->s.getQualification().equals(qualification)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public int getStudentCountByQualification(String qualification) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPlacedStudentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotPlacedStudentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CountDTO getPlacedAndNotPlacedCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float successRate(String batchName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> maxScoreStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStudentNames() {
		// TODO Auto-generated method stub
		return null;
	}

}