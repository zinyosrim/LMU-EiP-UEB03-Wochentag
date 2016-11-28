import  java.util.Scanner;

public class Weekday {

	private static Scanner scan;
	public static void main(String[] args){
		
		//read date from console
		scan = new Scanner(System.in);
		System.out.println("For determining the weekday please input the date");
		System.out.print("Enter year (yyyy): ");
		int y = scan.nextInt();
		System.out.print("Enter month (mm): ");
		int m= scan.nextInt();
		System.out.print("Enter day (dd): ");
		int d = scan.nextInt();
		
		//if date is a valid date print weekday to console
		if (validDate(y,m,d))
			System.out.print(d+"."+m+"."+y+" is a "+returnWeekday(y,m,d));
		//otherwise print error message
		else 
			System.out.print("date not valid, month must be 1-12, day 1-31. ");
		
	}
	//returns the name of a weekday for a given date
	public static String returnWeekday(int y, int m, int d){
		
		//calculate weekday as integer
		int y0 = y-(14-m)/12;
		int x = y0+y0/4-y0/100+y0/400;
		int m0 = m+12*((14-m)/12)-2;
		int d0 = (d+x+(31*m0)/12)%7;
		String weekday=null;
	
		//return name of day
		if (d0==0) weekday="Sunday";
		else if (d0==1) weekday="Monday";
		else if (d0==2) weekday="Tuesday";
		else if (d0==3) weekday="Wednesday";
		else if (d0==4) weekday="Thursday";
		else if (d0==5) weekday="Friday";
		else if (d0==6) weekday="Saturday";
		
		return weekday;
	}
	
	//checks if day is between 1-31 and month between 1-12 and returns true
	//otherwise returns fals
	public static Boolean validDate(int y, int m, int d){
		Boolean valid = true;
		if ((d>31) || (d<0)) valid = false;
		else if ((m>12) || (m<0)) valid = false; 
		
		return valid;
	}
	
}


