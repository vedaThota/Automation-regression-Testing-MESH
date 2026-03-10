package com.Mesh_TestSuites;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import org.testng.annotations.Test;

import com.Base.TestBase;

public class NewTest {
	
	public String fetchWeekdayDate(String format, int numberOfWeekdaysToBeAdded) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();

		int addedDays = 0;
		int direction = (numberOfWeekdaysToBeAdded >= 0) ? 1 : -1;

		while (addedDays != numberOfWeekdaysToBeAdded) {
			cal.add(Calendar.DATE, direction); // move one day forward or backward
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

			// Only count weekdays
			if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
				addedDays += direction;
			}
		}

		return df.format(cal.getTime());
	}
	
  @Test
  public void f() {
//	  SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");
//	  Calendar cal = Calendar.getInstance();
//
//	  int daysToAdd = 4;
//
//	  while (daysToAdd > 0) {
//	      cal.add(Calendar.DATE, 1);
//
//	      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//	      if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
//	          daysToAdd--;
//	      }
//	  }
//	  
	  String result = fetchWeekdayDate("M/d/yyyy", -2); 
	  System.out.println(result);

  }
}
