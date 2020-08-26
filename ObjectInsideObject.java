package com.prog;

class MyObj{
	public MyObj(int val, MyObj next) {
		this.val = val;
		this.next = next;
	}
	int val;
	MyObj next;
}

public class ObjectInsideObject {

	MyObj first = new MyObj(0, null);
	
	public static void main(String[] args) {
		
		ObjectInsideObject obj = new ObjectInsideObject();
		obj.insertObjects();
		
		obj.printObjects();
	}
	
	public void printObjects(){
		MyObj tmp = first;
		while(tmp.next != null){
			tmp = tmp.next;
			System.out.println(tmp.val);
		}
	}
	
	public void insertObjects(){
		for(int i=1;i<=10;i++){
			first.next = new MyObj(i, first.next);
		}
	}
}
