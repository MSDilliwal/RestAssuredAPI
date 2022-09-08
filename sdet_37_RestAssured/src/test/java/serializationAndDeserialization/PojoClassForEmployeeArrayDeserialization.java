package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.EmployeeArray;

public class PojoClassForEmployeeArrayDeserialization {

	public static void main(String[] args) throws Throwable{

		EmployeeArray empArr = new EmployeeArray();
		ObjectMapper objMap = new ObjectMapper();
		EmployeeArray emp = objMap.readValue(new File ("./EmpArray.json"), EmployeeArray.class);

		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpId());
		System.out.println(emp.getEmpEmail()[0]);
		System.out.println(emp.getEmpEmail()[1]);
		System.out.println(emp.getEmpPhone()[0]);
		System.out.println(emp.getEmpPhone()[1]);

	}
}
