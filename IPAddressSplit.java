package mylearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPAddressSplit {

	public static void main(String[] args) {
		
		IPAddressSplit obj = new IPAddressSplit();
		obj.defangIPaddr("1.2.3.4");
		
		String str = null;
		List<String> list = new ArrayList<>();
		if(str != null && !str.isEmpty())
			list = Arrays.stream(str.split(",")).collect(Collectors.toList());
		
		System.out.println("LIST : "+list.toString());
		
	}
	
	public String defangIPaddr(String address) {
        StringBuilder strBuild = new StringBuilder();
        String[] ssplit = address.split("\\.");
        int per = 1;
        for(String str : ssplit){
            strBuild.append(str);
            if(per <= 3)
                strBuild.append("[.]");
            per++;
        }
        return strBuild.toString();
    }
	
	private static List<String> convertToList(Object fromTunnelTagsObj){
		List<String> list = new ArrayList<>();
		if(fromTunnelTagsObj != null) {
 			list= Arrays.stream(fromTunnelTagsObj.toString().split(",")).collect(Collectors.toList());
 		}
		return list;
	}
	
}
