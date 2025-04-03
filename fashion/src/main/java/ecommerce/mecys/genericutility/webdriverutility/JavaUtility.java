package ecommerce.mecys.genericutility.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(100000);
		return ranDomNumber;
	}
	
	public String getSystemDateYYYYDDMM() {
		
		Date dateObject = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObject);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
	
}
