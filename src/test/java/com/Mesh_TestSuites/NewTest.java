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
		String date1 = "Oct 8, 2025 11:13 PM";
		String date2 = "Oct 8, 2025 11:14 PM";
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy h:m a");

		Date d1 = df.parse(date1);
		Date d2 = df.parse(date2);
		if(d1.equals(d2) || d2.after(d1))
			System.out.println("True");
		
		
	}
}
