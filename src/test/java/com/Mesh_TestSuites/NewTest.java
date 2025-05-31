package com.Mesh_TestSuites;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
	    Calendar cal = Calendar.getInstance();
	    
	    int addedDays = 0;
	    int direction = (-1 >= 0) ? 1 : -1;

	    while (addedDays != -1) {
	        cal.add(Calendar.DATE, direction);  // move one day forward or backward
	        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	        
	        // Only count weekdays
	        if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
	            addedDays += direction;
	        }
	    }


	    System.out.println(df.format(cal.getTime())); ;
  }
}
