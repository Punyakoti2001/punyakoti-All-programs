package com.zettamine.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

	public static void main(String[] args) {
		Costumer costumer = new Costumer();
		
		ObjectMapper obj = new  ObjectMapper();
		
		try {
			
//			String str = obj.writeValueAsString(costumer);
//			System.out.println(str);
			
			
//			String writeValueAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(costumer);
//			System.out.println(writeValueAsString);
			
			File file = new File("target/costumer.json");
			obj.writerWithDefaultPrettyPrinter().writeValue(file,costumer);
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
