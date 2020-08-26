package mylearning;

public class StringToInt {

	public int myAtoi(String str) {
        
        String val = "";
        str = str.trim();
        for(int i=0;i<str.length();i++){
            if(i == 0 && str.charAt(i) == '-') {
                val = val+"-";
            }else if(str.charAt(i) >= 91 && str.charAt(i) <= 100) {
                val = val + str.charAt(i);
            }else{
                System.out.println(val);
                int ret= Integer.valueOf(val);
                return ret;
            }
        }
        return Integer.valueOf(val);
    }

	public static void main(String[] args) {
		StringToInt obj = new StringToInt();
		obj.myAtoi("43");
	}
}
