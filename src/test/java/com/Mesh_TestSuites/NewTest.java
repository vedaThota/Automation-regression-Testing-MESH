package com.Mesh_TestSuites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() throws ParseException {

//		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy h:m a");
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 0);
//		System.out.println(df.format(cal.getTime()));
//
//		SimpleDateFormat df1 = new SimpleDateFormat("MMM d, yyyy h:m a");
//		Calendar cal1 = Calendar.getInstance();
//		cal1.add(Calendar.DATE, 2);
//		System.out.println(df1.format(cal1.getTime()));
//
//		if (cal.before(cal1) || cal.equals(cal1))
//			System.out.println("TRUE");
//		else
//			System.out.println("FALSE");
//		String date1 = "Oct 8, 2025 11:13 PM";
//		String date2 = "Oct 8, 2025 11:14 PM";
//		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy h:m a");
//
//		Date d1 = df.parse(date1);
//		Date d2 = df.parse(date2);
//		if(d1.equals(d2) || d2.after(d1))
//			System.out.println("True");
		
		String initials[] =  {
		        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
		        "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
		        "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
		        "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
		        "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
		    };

		// Generate a random index
		Random random = new Random();
		int index = random.nextInt(initials.length);

		// Return the character at that index
		System.out.println(initials[index]); 
		
		
	}
}
