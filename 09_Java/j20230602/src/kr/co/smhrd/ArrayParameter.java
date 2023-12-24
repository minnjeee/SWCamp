package kr.co.smhrd;

class CircleP{
	int radius;
	public double getArea() {
		return 3.14 *radius*radius;
	}
	
	public CircleP(int radius) {
		this.radius = radius;
	}
}


public class ArrayParameter {
	
	static void replaceSpace(char a[]) {
		for (int i=0; i<a.length; i++)
			if (a[i] == ' ')
				a[i] = ',';
	}
	
	static void printCharArray(char a[]) {
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]);
	System.out.println();
	}
	
	//----------------------------------------------
	static void increase(CircleP m) {
		m.radius++;
	}
	
	public static void main (String args[]) {
		char c[] = {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l','.'};
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
		
		
		//----------------------------------------------------
		CircleP pizza = new CircleP(14);
		double result = pizza.getArea();
		System.out.println("pizza의 넓이 : " + result);
		
		increase(pizza);
		
		result = pizza.getArea();
		System.out.println("Size Up pizza의 넓이 : " + result + "\n");
		
	}
}
