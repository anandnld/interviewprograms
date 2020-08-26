package mylearning;

public class CompareVersion {

	public static void main(String[] args) {
		
		String v1 = "0.1";
		String v2 = "0.01";
		
		System.out.println(new CompareVersion().compareVer_(v1, v2));
		
		
	}
	
	public int compareVer_(String v1, String v2) {
		
		String ver1 = "0";
		String ver2 = "0";
			
		for(int i=0, j=0;(i<v1.length() || j < v2.length());i++, j++) {
			
			while(i<v1.length() && v1.charAt(i) != '.') {
				ver1 = ver1 + v1.charAt(i);
				i++;
			}
			
			while(j<v2.length() && v2.charAt(j) != '.') {
				ver2 = ver2 + v2.charAt(j);
				j++;
			}
			
			if(Integer.valueOf(ver1) > Integer.valueOf(ver2)) {
				return 1;
			}else if(Integer.valueOf(ver1) < Integer.valueOf(ver2)) {
				return -1;
			}
			
			
			ver1 = "0";
			ver2 = "0";
		}
		
		if(Integer.valueOf(ver1) > Integer.valueOf(ver2)) {
			return 1;
		}else if(Integer.valueOf(ver1) < Integer.valueOf(ver2)) {
			return -1;
		}else {
			return 0;
		}
	}
}
