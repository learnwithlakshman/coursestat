package com.lwl.coursestat.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lwl.coursestat.domain.Student;

public final class CsvReaderUtil {
	private CsvReaderUtil() {
	}

	public static List<Student> readDataFromFile(String fileName) {

		List<Student> list = new ArrayList<Student>();

		try (Scanner sc = new Scanner(CsvReaderUtil.class.getResourceAsStream(fileName))) {
			sc.nextLine();
			String str = null;
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				Student student = converLineToStudent(str);
				list.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	private static Student converLineToStudent(String str) {
		String[] arr = str.split(",");
		int i = 0;
		String name = arr[i++];
		String batch = arr[i++];
		String cstatus = arr[i++];
		String pstatus = arr[i++];
		String qualification = arr[i++];
		float score = Float.parseFloat(arr[i++]);

		Student s = Student.builder().name(name).batch(batch).cstatus(cstatus).pstatus(pstatus)
				.qualification(qualification).score(score).build();
		return s;
	}
}