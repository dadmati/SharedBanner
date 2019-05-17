package Banner9Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class B9GetDateinJava {

 public static void main(String[] args) {
 
 // Create object of SimpleDateFormat class and decide the format
 DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
 
 //get current date time with Date()
 Date date = new Date();
 
 // Now format the date
 String date1= dateFormat.format(date);

 // Print the Date
 System.out.println("Current date and time is " +date1);
 
 
 
 }

 
 
}


