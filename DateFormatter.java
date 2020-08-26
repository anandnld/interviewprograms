package mylearning;

import java.time.LocalTime;

public class DateFormatter {

	public static void main(String[] args) {
		
		DateFormatter obj = new DateFormatter();
		System.out.println(obj.isValidDate("23:00"));
		
	}
	
	public boolean isValidDate(String time) {
		
		try {
			LocalTime.parse(time);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
