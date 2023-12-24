package kr.co.smhrd;
//import kr.co.smhrd.CircleIn;

public class Circle {
	Circle(){} //생성자 함수(기본적으로 있는 생성자, 생략되어 있는 것) -> 생략해도 사용할 수 있음
	Circle(int r, String n){ //생성자 함수2 (같은 이름의 다른 생성자 가능) -> 기능 부여한 생성자를 사용하려면 생략하면 안됌!
		radius = r;			// =>오버로딩
		name = n;
	}
	Circle(String n, int r){ //생성자함수3 :순서 다르게 오버로딩 가능(매개변수 이름을 바꾸면 x)
		radius = r;
		name = n;
	}

	int radius; // 멤버 변수(원의 반지름)
	String name; // 멤버 변수(원의 이름)
	
	public double getArea() { // 멤버 메소드 (원의 넓이 구하기)
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		Circle pizza; //Circle객체 선언
		pizza = new Circle(); //Circle객체 생성
		// Circle pizza = new Circle(); (위의 두개 한번에 사용 가능, Circle 선언과 생성 동시에)
		pizza.radius = 10;
		pizza.name = "자바피자";
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 "+ area);
		
		Circle donut = new Circle(); //Circle객체 선언과 생성 (생성자 함수1 사용)
		donut.radius = 2;
		donut.name = "자바도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 "+ area);
		
		///// 생성자 함수2 사용하기
		Circle bdd = new Circle(12, "빈대떡"); //Circle 객체 선언과 생성(생성자함수2사용)
		area = bdd.getArea();
		System.out.println(bdd.name + "의 면적은 "+ area);
		
		///// 생성자 함수3 사용하기
		Circle pjeon = new Circle("파전", 8); //Circle 객체 선언과 생성(생성자함수3사용)
		area = pjeon.getArea();
		System.out.println(pjeon.name + "의 면적은 "+ area);
		
		CircleIn ci = new CircleIn(10);
		double result = ci.getArea();
		System.out.println(result);
	}

}
