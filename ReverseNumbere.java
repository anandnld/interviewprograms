package mylearning;

public class ReverseNumbere {

	public static void main(String[] args) {
	
		
		int[] arr = new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		
		ReverseNumbere obj = new ReverseNumbere();
		obj.reverse(9646324351);
	}
	
	public int reverse(int x) {
        String rev = String.valueOf(x);
        String finalInt = "";
        for(int i=0;i<rev.length();i++){
            if(rev.charAt(i) != '-')
                finalInt = rev.charAt(i)  + finalInt;
        }
        if(rev.charAt(0) == '-')
            finalInt = "-"  + finalInt;
    
        return Integer.valueOf(finalInt);
        
    }
}
