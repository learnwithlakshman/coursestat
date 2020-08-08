package com.lwl.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	@Test
	void jsonStrToJavaObjectTest() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = "{\"empno\":1001,\"ename\":\"Krish\",\"address\":{\"city\":\"GNT\",\"state\":\"AP\"},\"emails\":[\"krish.t@gmail.com\",\"krish.t@wipro.com\"],\"workingStatus\":true,\"salary\":98000.5}";

		try {
			Employee emp = mapper.readValue(jsonStr, Employee.class);
			System.out.println(emp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void javaObjectToJSONString() {

		List<String> emails = Stream.of("tanvi.a@gmail.com").collect(Collectors.toList());
		Address address = Address.builder().city("Bangalore").state("KA").build();

		Employee emp = Employee.builder().empno(1002).ename("Tanvi").salary(85000).emails(emails).address(address)
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		

	}
	
	@Test
	void javaObjectToJSONFile() {
		List<String> emails = Stream.of("tanvi.a@gmail.com").collect(Collectors.toList());
		Address address = Address.builder().city("Bangalore").state("KA").build();

		Employee emp = Employee.builder().empno(1002).ename("Tanvi").salary(85000).emails(emails).address(address)
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		try {
			JsonGenerator jsonCreator = factory.createGenerator(new File("employees.json"),JsonEncoding.UTF8);
			jsonCreator.setCodec(mapper);
			jsonCreator.useDefaultPrettyPrinter();
			jsonCreator.writeObject(emp);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	@Test
	void readingJSONArrayFromFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Employee> list = mapper.readValue(new File("employees_seed_data.json"), new TypeReference<List<Employee>>() {});
			list.stream().forEach(e->{
				System.out.println(e);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
