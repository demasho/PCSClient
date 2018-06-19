package application;
import java.util.Calendar;
import java.lang.Object;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validator {
	
	static int arrivalMin;
	static int arrivalHr;
	static int finishHr;
	static int finishMin;
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	
	
	public static boolean isValidCarNumber(String carNum)
	{
		if(!isNum(carNum) || carNum.length()!=7) return false;
		
		else return true;
		
	}
	public static boolean isValidPersonId(String id)
	{
		if(!isNum(id) || id.length()!=9) return false;
		
		else return true;
		
	}
	public static boolean isValidRequestedPark(String id)
	{
		if(!isNum(id)) return false;
		
		else return true;
		
	}
	public static boolean isValidArrivalTime(String minute , String hour)
	{
		if(!isNum(minute) || !isNum(hour)) return false;
		
		arrivalMin = Integer.parseInt(minute);
		arrivalHr =  Integer.parseInt(hour);
		
		if(arrivalMin > 59 || arrivalMin < 0 || arrivalHr > 24 || arrivalHr<0 ) return false;
		
		
		return true;
	}
	
	public static boolean isValidEndTime(String minute , String hour)
	{
		if(!isNum(minute) || !isNum(hour)) return false;
		
		finishMin = Integer.parseInt(minute);
		finishHr =  Integer.parseInt(hour);
		
		if(finishMin > 59 || finishMin < 0 || finishHr > 24 || finishHr<0 ) return false;
		
		return true; 
		
	}
	
	public static boolean isValidDates(Calendar beginDate  , Calendar endDate)
	{
		Calendar currentTime = Calendar.getInstance();
		
		if(beginDate.compareTo(currentTime)<0)
		{
			return false;
		}
		if( beginDate.compareTo(endDate) > 0) 
		{
			return false;
		}
		if( beginDate.compareTo(endDate) == 0) 
		{
			if(finishHr < arrivalHr || (finishHr == arrivalHr && finishMin<arrivalMin)) return false; 
			
		}
		
		return true;
	}
	/************* help function *******************/
	public static boolean isNum(String str)
	{
		boolean numeric = true;
		try {
			Double num = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			numeric = false;
		}
		
		return numeric;
	}
	
}
