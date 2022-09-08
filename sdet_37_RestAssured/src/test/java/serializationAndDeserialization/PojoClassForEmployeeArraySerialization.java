package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassesForSerializationAndDeserialization.EmployeeArray;

public class PojoClassForEmployeeArraySerialization  extends EmployeeArray{

	public static void main(String[] args) throws Throwable{
		
		String [] empEmail = {"wil@gmail.com","wil123@gmail.com"};
		int [] empPhone = {49856,87498};
		
		EmployeeArray empArr = new EmployeeArray("William","wil123",empEmail, empPhone);
	
		ObjectMapper objmap = new ObjectMapper ();
		objmap.writeValue(new File ("./EmpArray.json"),empArr);
		
		
		
	}
}
