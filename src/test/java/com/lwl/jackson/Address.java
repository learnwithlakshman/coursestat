package com.lwl.jackson;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private String city;
	private String state;
	

	
	
	
}
