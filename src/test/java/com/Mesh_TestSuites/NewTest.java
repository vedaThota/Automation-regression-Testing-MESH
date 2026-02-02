package com.Mesh_TestSuites;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");
	  Calendar cal = Calendar.getInstance();

	  int daysToAdd = 4;

	  while (daysToAdd > 0) {
	      cal.add(Calendar.DATE, 1);

	      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	      if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
	          daysToAdd--;
	      }
	  }
	  
	  System.out.println(df.format(cal.getTime())); ;

  }
}
