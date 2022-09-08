package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.Employee;

public class PojoClassForAnEmployeeDeserialization extends PojoClassForAnEmployeeSerialization {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		
		//Create an object for Employee class
		Employee emp = new Employee();
		
		//Create an object for ObjectMapper
		ObjectMapper objMap = new ObjectMapper ();
		
		//read the file which already been created in the project using readValue method
		Employee employee = objMap.readValue(new File("./emp.json"), Employee.class);
		
		//print the values 
	    System.out.println(employee.getEmpName());
	    System.out.println(employee.getEmpId());
	    System.out.println(employee.getEmpEmail());
	    System.out.println(employee.getEmpPhone());
	}
}
