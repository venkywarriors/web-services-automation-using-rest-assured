package interactivePDFs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddDates {
	   public static void main(String[] args) {
		   
		      // create a calendar
		      Calendar cal = Calendar.getInstance();
		      
		      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		      String strDate= formatter.format(cal.getTime());
		      
		      System.out.println(strDate);
		      
		      // print current date
		      System.out.println("The current date is : " + cal.getTime());
		      
		      // add 50 days to the calendar
		      cal.add(Calendar.DATE, 50);
		      System.out.println("50 days later: " + cal.getTime());

		      // subtract 2 months from the calendar
		      cal.add(Calendar.MONTH, -2);
		      System.out.println("2 months ago: " + cal.getTime());

		      // subtract 5 year from the calendar
		      cal.add(Calendar.YEAR, -5);
		      System.out.println("5 years ago: " + cal.getTime());  
		     
		      
		      
	   }
}
