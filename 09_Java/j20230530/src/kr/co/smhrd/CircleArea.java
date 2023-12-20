package kr.co.smhrd;

public class CircleArea {

	public static void main(String[] args) {
		final double PI = 3.14; //원주율을 상수로 선언
		double radius = 10.2; //원의 반지름
		double circleArea = radius*radius*PI; //원의 면적 계산
		
		//원의 면적을 화면에 출력
		System.out.print("반지름 "+radius+", ");
		System.out.println("원의 면적 = " + circleArea);
		
		radius = 20.5; //변수 선언 시 타입을 이미 줬기 때문에 다시 타입지정할 필요x
		//PI = 3.14159265; // 상수이므로 변경 불가능
		circleArea = radius*radius*PI;
		System.out.print("반지름 "+radius+", ");
		System.out.println("원의 면적 = " + circleArea);
		
		byte b = 127;
		int i = 100;
		System.out.println(b+i); 	//127+100 = 227
		System.out.println(10/4);	//10/4 = 2(정수의 연산은 정수이므로 몫)
		System.out.println(10.0/4);	//10.0/4.0 = 2.5 (4는 4.0으로 자동변환)
		System.out.println((char)0x12340041);
		System.out.println((byte)(b+i));	//227을 byte타입으로 강제변환
		System.out.println((int)2.9 + 1.8);	//2+1.8 = 3.8 (강제변환)
		System.out.println((int)(2.9+1.8));	//4.7을 int형으로 강제변환
		System.out.println((int)2.9 + (int)1.8);	//2+1=3 (강제변환)
	}

}
