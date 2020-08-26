package com.prog;

public class MainApp {
	
	public static void main(String[]args){
		for(int i=1;i<10;i++){
			if(i!=0){
				if(i==2){
					continue;
				}
			}
			
			System.out.println("hello"+i);
		}
	}

}
