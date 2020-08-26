package com.prog;

import java.util.Arrays;
import java.util.List;

public class ReplaceAll {

	public static void main(String[] args) {
		String str = "0bf05f0e-a557-4304-aacf-dca0e5798358,e553b837-4818-4435-ad80-1d9081bacbc6";
		List<String> nameSpaceList = Arrays.asList(str);
        for (String nSpace : nameSpaceList) {
        	System.out.println(nSpace);
        }
	}
}
