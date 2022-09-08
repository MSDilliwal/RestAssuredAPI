package genericUtility;

import java.io.File;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Hp Lap
 *
 */
public class JavaUtility {
/**
 * To get the random number
 * @return
 */
	public int getRandomNum()
	{
		Random random = new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}
	/**
	 * To get system date and time
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date date = new Date();
		String dateTime = date.toString();
		return dateTime;
	}
	/**
	 * To get system date and time in required format
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		Date date1 =new Date();
		String dateTime = date1.toString();
		String[] dateArray = dateTime.split(" ");
	
		
		int month = date1.getMonth()+1;
		String date = dateArray[2];
		String year = dateArray[5];
		int day = date1.getDay();
		String time = dateArray[3];
		
		String finalFormat = month+" "+date+" "+year+" "+day+" "+time+" ";
		return finalFormat;
	}	
}
