package mylearning;

import java.util.Arrays;

class Recurrance {
	
	int recurrenceListSelect = 0;
	private String dayOfWeekIntervalDayOfWeek = "1";
}


public class MyListTest {

	public static void main(String[] args) {
		
		Recurrance recurrence1 = new Recurrance();
		
		if(doesObjectContainField(recurrence1, "dayOfWeekIntervalStartTime")) {
			System.out.println("Field present");
		}else {
			System.out.println("Field not present");
		}
		
		if(doesObjectContainField(recurrence1, "dayOfWeekIntervalDayOfWeek")) {
			System.out.println("Field present");
		}else {
			System.out.println("Field not present");
		}
	}
	
	
	public static boolean doesObjectContainField(Object object, String fieldName) {
		return Arrays.stream(object.getClass().getDeclaredFields()).anyMatch(f -> f.getName().equals(fieldName));
	}
}

