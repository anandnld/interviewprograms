package com.prog;
enum Days{
//	0		1		 2			3		  4		  5			6	
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumOrdinal {
	public static void main(String[] args) {
		Days mon = Days.MONDAY;
		Days wed = Days.WEDNESDAY;
		Days tus = Days.TUESDAY;
		Days fri = Days.FRIDAY;
		Days sun = Days.SUNDAY;
		
		System.out.println("Monday ordinal    : "+mon.ordinal());
		System.out.println("Wednesday ordinal : "+wed.ordinal());
		System.out.println("Tuesday ordinal   : "+tus.ordinal());
		System.out.println("Friday ordinal    : "+fri.ordinal());
		System.out.println("Sunday ordinal    : "+sun.ordinal());
	}
}
