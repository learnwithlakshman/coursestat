package com.lwl.coursestat.util.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

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
class Employee {
	private String name;
	private String email;
	private String mobile;
	private String qualification;
	private double salary;

}

public class SampleExample {

	@Test
	public void totalSalary() {
		
		List<Employee> list = getSeedData();
//		double tsal = 0;
//		for(int i =0 ;i<list.size();i++) {
//			Employee emp=list.get(i);
//			tsal += emp.getSalary();
//		}
//		System.out.println("Total Salary :"+tsal);
		
//		double tsal = list.stream().mapToDouble(e->e.getSalary()).sum();
//		System.out.println("Total Salary :"+tsal);
		
//		List<String> namesList = new ArrayList<String>();
//		
//		for(Employee emp:list) {
//			namesList.add(emp.getName());
//		}
//		System.out.println(namesList);
		
//		List<String> namesList = list.stream().map(e->e.getName()).collect(Collectors.toList());
//		System.out.println(namesList);

    	String qualification = "M.Tech";
//		
//		List<Employee> empList = new ArrayList<>();
//		for(Employee emp:list) {
//			if(emp.getQualification().equals(qualification)) {
//				empList.add(emp);
//			}
//		}
		
		List<Employee> empList = list.stream()
				                      .filter(e->e.getQualification().equals(qualification))
				                      .collect(Collectors.toList());
		
		System.out.println("Employee with :"+qualification+" count is :"+empList.size());
		
	}
	
	private List<Employee> getSeedData() {
		Employee e1 = new Employee.EmployeeBuilder().name("Rajesh").email("rajesh.t@lms.com").mobile("9998887771")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e2 = new Employee.EmployeeBuilder().name("Suresh").email("suresh.s@lms.com").mobile("9998887772")
				.qualification("Ph.D").salary(89000.0).build();
		Employee e3 = new Employee.EmployeeBuilder().name("Ramesh").email("ramesh.r@lms.com").mobile("9998887773")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e4 = new Employee.EmployeeBuilder().name("Jayesh").email("jayesh.s@lms.com").mobile("9998887774")
				.qualification("B.Tech").salary(39000.0).build();
		Employee e5 = new Employee.EmployeeBuilder().name("Kamesh").email("kamesh.k@lms.com").mobile("9998887775")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e6 = new Employee.EmployeeBuilder().name("Ramit").email("ramit.r@lms.com").mobile("9998887776")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e7 = new Employee.EmployeeBuilder().name("Sumith").email("sumit.s@lms.com").mobile("9998887777")
				.qualification("Ph.D").salary(99000.0).build();
		Employee e8 = new Employee.EmployeeBuilder().name("Kirmit").email("kirmit.k@lms.com").mobile("9998887778")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e9 = new Employee.EmployeeBuilder().name("Balu").email("balu.b@lms.com").mobile("9998887779")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e10 = new Employee.EmployeeBuilder().name("Sony").email("sony.s@lms.com").mobile("9998887780")
				.qualification("M.Tech").salary(49000.0).build();
		Employee e11 = new Employee.EmployeeBuilder().name("Deepu").email("deepu.d@lms.com").mobile("9998887781")
				.qualification("B.Tech").salary(38000.0).build();
		return Stream.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11).collect(Collectors.toList());
	}

}
