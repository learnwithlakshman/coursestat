package com.lwl.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

interface Calc {
	public int perform(int a, int b);
}

interface MyPredicate<T> {
	public boolean test(T t);
}

@Builder
class Address{
	private String city;
	private String state;
}
class Passport{
	private String passportNumber;
	private String issued;
	private LocalDate issueDate;
	private LocalDate expiryDate;
}
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
class Employee{
	private int empno;
	private String ename;
	private String email;
	private String mobile;
	private Address address;
	private Passport passport;
	private String qualification;
	

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", passport=" + passport + ", qualification=" + qualification + "]";
	}
	
	
	
	
	
}



public class LambdaExpressionTest {

	@Test
	void additionOfNumber() {

		Calc add = (a, b) -> a + b;
		Calc mul = (a, b) -> a * b;

		System.out.println(add.perform(10, 20));
		System.out.println(mul.perform(10, 20));
	}

	@Test
	void predicateTest() {
		
		
		List<Integer> mylist = new ArrayList<Integer>();
		mylist.add(1);
		mylist.add(2);
		mylist.add(3);
		mylist.add(4);
		mylist.add(5);
		mylist.add(6);
		mylist.add(7);
		
//		for(int i=0;i<mylist.size();i++) {
//			System.out.println(mylist.get(i));
//		}
		
//		for(Integer ele:mylist) {
//			System.out.println(ele);
//		}
		
		mylist.stream().forEach(System.out::println);
		
		List<Integer> evenList = filter(mylist,(ele)->ele % 2 == 0);
		List<Integer> oddList = filter(mylist,(ele)->ele % 2 != 0);
		List<Integer> divisableBy5 = filter(mylist, (ele)->ele % 5 == 0);
		
		
		
		
		System.out.println(evenList);
		System.out.println(oddList);
		

	}
	
	@Test
	public void employeeObjectCreationTest() {
		Employee emp = Employee.builder()
				               .empno(1001)
				               .email("krish@gmail.com")
				               .ename("Krishna")
				               .address(Address.builder().city("BLR").state("KA").build())
				               .qualification("B.Tech").build();
		System.out.println(emp);
	}

	public List<Integer> filter(List<Integer> list,Predicate<Integer> p) {

		List<Integer> temp = new ArrayList<Integer>();

		for (Integer i : list) {
			if (p.test(i)) {
				temp.add(i);
			}
		}
		return temp;
	}
	
	
	

}
