package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtlity {
public int getRandomNum() {
	Random random=new Random();
	int randomNUM=random.nextInt(1000);
	return randomNUM;
}
public String getSystemDateYYYYDDMM() {
	Date dateobj=new Date();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(dateobj);
	return date;
	
}
public String getSystemDateYYYYMMdd() {
	Date d = new Date();
	SimpleDateFormat fm = new SimpleDateFormat("YYYY-MM-dd");
	String date =  fm.format(d);      
	return date;
}
public String getRequireddateYYYYMMdd(int days) {
	Date d = new Date();
	SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
	String date = fm.format(d);
	 Calendar cal = fm.getCalendar();
     cal.add(Calendar.DAY_OF_MONTH,days);
    String Requireddate = fm.format(cal.getTime());
	return Requireddate;
}
}


