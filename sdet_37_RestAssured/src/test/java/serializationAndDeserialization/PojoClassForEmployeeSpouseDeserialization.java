package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.Employee1;
import pojoClassesForSerializationAndDeserialization.EmployeeSpouse;

public class PojoClassForEmployeeSpouseDeserialization {

	public static void main(String[] args) throws Throwable {
		
		EmployeeSpouse empSpoue =new EmployeeSpouse();
		
		ObjectMapper objMap = new ObjectMapper();
		Employee1 employee1 = objMap.readValue(new File("./EmployeeSpouse1.json"),Employee1.class);
		
		System.out.println(employee1.getEmpName());
		System.out.println(employee1.getEmpId());
		System.out.println(employee1.getEmpPhone());
		System.out.println(employee1.getEmpEmail());
		System.out.println(employee1.getSpouse());
	}
}
