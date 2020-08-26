package mylearning;

public class MaxLength {

	public static void main(String[] args) {
		
		String mainStr = "suncityapartments";

		  String longSubStr = longSubString(mainStr);

		  System.out.println("ORIGINAL STRING    ::: " + mainStr);
		  System.out.println("LONGEST SUB STRING ::: " + longSubStr);
		
	}
	
	public static String longSubString(String mainStr) {

		  String longStr = "";
		  String tmp = "";

		  char[] charArray = mainStr.toCharArray();

		  for (int i = 0; i < mainStr.length(); i++) {

		   if (tmp.contains(charArray[i] + "")) {

		    if (longStr.length() < tmp.length()) {
		     longStr = tmp;
		    }

		    tmp = tmp.substring((tmp.indexOf(charArray[i]) + 1), tmp.length());
		    tmp = tmp + charArray[i];

		   } else {
		    tmp = tmp + charArray[i];
		   }
		  }

		  if (longStr.length() < tmp.length()) {
		   longStr = tmp;
		  }

		  return longStr;
		 }
}
