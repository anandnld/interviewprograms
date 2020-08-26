package com.prog;


class A{
	public void add(){
		System.out.println("a");
	}
}

class B extends A{
	public void add(){
		System.out.println("b");
	}

}
public class MainApp11 extends A{

	public static void main(String[]args){
		A obj=null;
		B obj1=null;
		obj.add();
	}
	
}
