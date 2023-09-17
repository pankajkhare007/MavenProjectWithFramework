package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	
	public static String randomName() {
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYYHHmmss");
		String str = formatter.format(currentDate.getTime());
		return str;
	}

}
