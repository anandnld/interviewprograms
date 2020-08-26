package mylearning;

import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
	
		ValidNumber obj = new ValidNumber();
		System.out.println(obj.isNumber("0e"));
	}
	
	public boolean isNumber_(String s) {
		Pattern pattern = Pattern.compile("/[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)/g");
		return pattern.matcher(s).matches();
	}
	
	public boolean isNumber(String s) {
	     
		 s = s.trim();
		 
        if(s == null || s.length() == 0) return false;
        
        boolean expo = false;
        boolean sign = false;
        boolean deci = false;
        boolean num = false;
       
        if(s.charAt(0) == 'e') return false;
        if(s.charAt(0) == '.' && s.length() == 1) return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') sign = true;
        if(s.charAt(0) == '.') deci = true;
            
        if((int)s.charAt(0) >=49 && (int)s.charAt(0) <= 57){
        	num = true;
        }
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) == ' ') return false;
            if(expo && s.charAt(i) == 'e') return false;
            if(sign && (s.charAt(i) == '-' || s.charAt(i) == '+')) return false;
            if(deci && s.charAt(i) == '.') return false;
            if(expo && s.charAt(i) == '.') return false;
            if(!num && s.charAt(i) == 'e') return false;
            
            if((int)s.charAt(i) >=48 && (int)s.charAt(i) <= 57){
            	num = true;
                continue;
            }
            if(!expo && s.charAt(i) == 'e') {
                expo = true; 
                continue;
            }
            if(!deci && s.charAt(i) == '.') {
                deci = true; 
                continue;
            }
            if(expo && s.charAt(i-1) == 'e' && s.charAt(i) == '-') {
                expo = true;
                continue;
            }
            
            return false;
        }
        return true;
    }
}
