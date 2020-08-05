package com.lwl.coursestat.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lwl.coursestat.domain.Student;
import com.lwl.coursestat.util.CsvReaderUtil;

public class CsvReaderUtilTest {

		String fileName = "/coursedata.csv";
		
		@Test
		public void readDataFromFile() {
			List<Student> list = CsvReaderUtil.readDataFromFile(fileName);
			assertEquals(15, list.size());
		}
}
