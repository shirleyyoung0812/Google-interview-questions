//Summary of the format
import java.util.Calendar;
import java.util.GregorianCalendar;


public class StringFormat {

	public static void main(String[] args) {
		System.out.println("******integer format******");
		//if the number of digits is less than 4, the output will 
		//have leading spaces
		System.out.println("**" + String.format("%4d", 123) + "**");
		//if the number of digits is less than 4, the output will 
		//have trailing spaces
		System.out.println("**" + String.format("%-4d", 123) + "**");
		//if the number of digits is less than 4, the output will 
		//have leading zeros
		System.out.println("**" + String.format("%04d", 123) + "**");
		//will print maximum 2 characters of the string
		System.out.println("**" + String.format("%.2d", 123) + "**");
		//String will have at least length of 7, if the total length is 
		//less than 7, trailing space, group by ","
		//"+": including sign 
		System.out.println("**" + String.format("%+,7d",-1234) + "**");
		
		System.out.println("\n******String format******");
		//if the length of string is less than 15, the output will 
		//have trailing spaces
		System.out.println("**" + String.format("%15s", "abcdefghijk") + "**");
		//if the length of string is less than 15, the output will 
		//have leading spaces
		System.out.println("**" + String.format("%-15s", "abcdefghijk") + "**");
		//print at most 8 characters
		System.out.println("**" + String.format("%.8s", "abcdefghijk") + "**");
		
		
		System.out.println("\n******Floating point******");
		//actual number
		System.out.println("**" + String.format("%f", 3.14159) + "**");
		//padded left with zeros
		System.out.println("**" + String.format("%8f", 3.14159) + "**");
		//maximum 8 digits, if total digits is less than 8
		//padded left with zeros
		System.out.println("**" + String.format("%.8f", 3.14159) + "**");
		//total 10 digits, will have trailing blank spaces if total digits
		//is less than 10, at most 3 digits after the decimal point
		System.out.println("**" + String.format("%-10.3f", 3.14159) + "**");
		//total 10 digits, will have leading blank spaces if total digits
		//is less than 10, at most 3 digits after the decimal point
		System.out.println("**" + String.format("%10.3f", 3.14159) + "**");
		
		System.out.println("\n******time date******");
		//Calendar c = Calendar.getInstance();
		//year, the month with index 2 starting from 0 (0: January), date
		Calendar c = new GregorianCalendar(2015, 2, 1, 3, 24, 39);
		//full name of month, date(leading zeros if needed, only for date), 
		//4-digit year
		System.out.println(String.format("%tB %td, %tY", c, c, c));
		//full name of month, date(no leading zero, only for date), 
		//4-digit year
		System.out.println(String.format("%tB %te, %tY", c, c, c));
		//full name of month, date(no leading zero, only for date), 
		//2-digit year
		System.out.println(String.format("%tB %te, %ty", c, c, c));
		//month in two digits, with leading zero if necessary
		System.out.println(String.format("%tm %te, %tY", c, c, c));
		//can only be used on time, no date year can be included
		//12-hour clock : minute
		System.out.println(String.format("%tl:%tM%tp", c, c, c));
		//== %tm/%td/%ty
		System.out.println(String.format("%tD",c));
		System.out.println(String.format("%tm/%td/%ty", c, c, c));
	}
}
