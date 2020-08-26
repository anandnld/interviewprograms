package com.prog;

import java.net.InetAddress;

public class IPCheck {

	public static void main(String[] args) {
		//String ip1 = "0009:000a:0029:008f:0000:0000:0000:0000";
		//String ip2 = "0009:000a:0029:0090:0000:0000:0000:0000";
		//String ip3 = "0000:0000:0000:0000:0000:0000:0000:0000";
		String ip3 = "9:a:29:8f::";
		
		if(ip3.contains(":")){
			String[] splitIp = ip3.split(":");
			StringBuilder strBuild = new StringBuilder();
			for(int i=0;i<4;i++){
				strBuild.append(Integer.parseInt(splitIp[i], 16)).append(i<=2 ? "." : "");
			}
			System.out.println("IP ::: "+strBuild.toString());
		}
		
		
	}
}
