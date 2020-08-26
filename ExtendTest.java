package mylearning;

class Parent {
	public void myMethod() {
		System.out.println("In parent");
	}
}

public class ExtendTest extends Parent{

	@Override
	public void myMethod() {
		System.out.println("In child");
	}
	
	public static void main(String[] args) {
		
		Parent obj = new ExtendTest();
		obj.myMethod();
		
	}
}
