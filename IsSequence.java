package mylearning;

public class IsSequence {

	public static void main(String[] args) {
		IsSequence obj = new IsSequence();
		boolean result = obj.isSubsequence("axc", "ahbgdc");
		System.out.println("OUTPUT: "+result);
	}
	
	public boolean isSubsequence(String s, String t) {
	     
        if(s == null || s.equals("") || t == null || t.equals("")) 
            return false;
        
        for(int i=0, j=0;i<t.length() && j<s.length();i++){
            if(t.charAt(i) == s.charAt(j)) {
                j++;
                if(j == s.length()) return true;
            }
        }
        return false;
    }
}
