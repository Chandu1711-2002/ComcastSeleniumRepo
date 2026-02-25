package PracticeContactsTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateobj=new Date();
		
		//to get current date
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");  //MM should be in capital only
		String actualdate=sim.format(dateobj);
		System.out.println(actualdate);
		
		
		
		//to get date after some days or before some days
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequires=sim.format(cal.getTime());
		System.out.println(dateRequires);
		

	}

}
