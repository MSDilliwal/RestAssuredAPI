package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.Employee;

public class PojoClassForAnEmployeeSerialization extends Employee{

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		
		// Create an object for Employee
		Employee emp = new Employee ("Bentley","Ben777","ben777@gmail.com",6579167961l);
		
		// Create an object for ObjectMapper
	    ObjectMapper objMap = new ObjectMapper ();
	    
	    // Create a new file with the help of .json format
	    objMap.writeValue(new File("./emp.json"), emp);
	}
}
