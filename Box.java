package com.prog;

public class Box implements Comparable<Box>{

	int h, w, d, area; 
	
	public Box() {
		// TODO Auto-generated constructor stub
	}
	
	public Box(int h, int w, int d) { 
        this.h = h; 
        this.w = w; 
        this.d = d; 
    } 
	
	@Override
	public int compareTo(Box o) {
		return o.area-this.area; 
	}
}
