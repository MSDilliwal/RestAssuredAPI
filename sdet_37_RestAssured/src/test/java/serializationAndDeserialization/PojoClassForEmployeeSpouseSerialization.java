package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.Employee1;
import pojoClassesForSerializationAndDeserialization.EmployeeSpouse;

public class PojoClassForEmployeeSpouseSerialization {

	public static void main(String[] args) throws Throwable {

		EmployeeSpouse empSpouse = new EmployeeSpouse("Sam", 58794, "Bangalore");
		
		Employee1 emp1 = new Employee1 ("Bentley","Ben777","ben777@gmail.com",6579167961l, empSpouse);
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File ("./EmployeeSpouse1.json"), emp1);
	}



}
