import java.util.*;
import java.text.*;

public class BurroughsTest {

    //Gets date of the last day of each month
    public static Date getNextDate(Date nowDate, int nextMonth) {
    
            //Instantiate current date
            Calendar c = Calendar.getInstance(); 
            //For loop in main method increments month each iteration
            c.add(Calendar.MONTH, nextMonth);
            //Current date first day
            c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
            Date nextMonthFirstDay = c.getTime();
            //Current date last day
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            //Declare and return current date
            Date nextDate = c.getTime();
            return nextDate;
    }
    
    //Same but for getting 15th day of each month
    private static Date getFifteenth(Date fifteenth, int nextMonth) {
    
            Calendar c = Calendar.getInstance();         
            c.add(Calendar.MONTH, nextMonth);
            //Set current date to 15th
            c.set(Calendar.DATE, 15);
            
            Date nextDate = c.getTime();
            return nextDate;
    }
    
    //Converts date to string of the day name
    private static String printDay(Date nextDate) {
 
            DateFormat format = new SimpleDateFormat("EEEE");
            
            return format.format(nextDate);
    
    }
    
    //Converts date to string of month name
    private static String printMonth(Date nextDate) {

            DateFormat format = new SimpleDateFormat("MMMM");
            
            return format.format(nextDate);
    
    }
    
    //Converts date to year string
    private static String printYear(Date nextDate) {

            DateFormat format = new SimpleDateFormat("YYYY");
            
            return format.format(nextDate);
    
    }
    
    //Calculates day before current date (for saturdays)
    private static Date dayBefore(Date nextDate) {
            Calendar c = Calendar.getInstance();
            c.setTime(nextDate);
            //current day minus 1
            c.add(Calendar.DAY_OF_MONTH, -1);
            return c.getTime();
    }
    
    //Calculates two days before current date (for Sundays)
    private static Date TwoDaysBefore(Date nextDate) {
            Calendar c = Calendar.getInstance();
            c.setTime(nextDate);
            //current day minus 2
            c.add(Calendar.DAY_OF_MONTH, -2);
            return c.getTime();
    }
    
    //Calculates the next Wednesday after the date (for bonus day)
    private static Date nextWednesday(Date nextDate) {
            Calendar c = Calendar.getInstance();
            c.setTime(nextDate);
            //Keep incrementing days until the next wedneday
            while (c.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY){
                c.add(Calendar.DATE, 1);
            }
            return c.getTime();
    }
    
    public static void main(String[] args) {
    
            //NB nextDate = last date of the month
            
            //Initialise number of months to 0
            int nextMonth = 0;
            
            //Begin for loop
            for(int i=1; i<13; i++){
                
                //Set todays date and pass to next date and 15th methods
                Date nowDate = new Date();
                Date nextDate = getNextDate(nowDate, nextMonth);
                Date fifteenth = getFifteenth(nowDate, nextMonth);
                //Nice format for the dates
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
                
                //Print the months, their last days and 15th days
                System.out.println();
                System.out.print(printMonth(nextDate)+" "+printYear(nextDate)+" | ");
                System.out.print("Last Day: "+printDay(nextDate));
                System.out.print(" | 15th: "+printDay(fifteenth)+" | ");
                
                //Instantiate date
                Calendar c = Calendar.getInstance();
                //Set to nextDate
                c.setTime(nextDate);
                
                //If last day is a saturday do day before method
                if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                    System.out.print("Pay Day: "+sdf.format(dayBefore(nextDate)));
                    
                //Else if its a sunday do two days before
                }else if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    System.out.print("Pay Day: "+sdf.format(TwoDaysBefore(nextDate)));
                    
                //Else print current date    
                }else {
                    System.out.print("Pay Day: "+sdf.format(nextDate));
                }
                
                //Now set calender to 15th
                c.setTime(fifteenth);
                
                //And do the same for 15th, if its sat or sun do wednesday method
                if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    System.out.print(" | Bonus Day: "+sdf.format(nextWednesday(fifteenth)));
                //Else print date
                }else {
                    System.out.print(" | Bonus Day: "+sdf.format(fifteenth));
                }
                System.out.println();
                
                //Increment month number
                nextMonth = nextMonth + 1;
            }
    }
}
