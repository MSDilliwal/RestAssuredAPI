package javaLibrary;

import java.util.Random;

public class JavaLibrary {

	public int getRandomNumber() {
	    Random random = new Random();
	    int randomNum = random.nextInt(500);
		return randomNum;
		
	}
}
