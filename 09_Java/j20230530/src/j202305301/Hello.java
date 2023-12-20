package j202305301;

public class Hello { //클래스

	public static int sum(int n, int m) { //메소드 (sum함수는 매개변수로 두 개의 정수형을 받아서 정수형 결과값 반환)
		return n+m;							// 함수는 선언만 되고 main메소드 실행 -> 함수 실행되는 순간에만 잠깐 메모리 차지 후 결과전달하고 메모리에서 사라짐
	}
	
	//main()메소드에서 실행
	public static void main(String[] args) { //(하나의 클래스 안에 main 함수는 딱 하나만) -> 메모리 차지
		int i=20; //먼저 선언해줘야 함!
		int s;
		char a;
		String st;
		
		s = sum(i,10); //sum함수 호출, 매개변수는 변수도 가능 //s=20+10 //int는 4바이트
		a = '?'; //char타입은 문자 하나만 가능 //char는 2바이트
		st = "스마트인재개발원 고청심 선생님"; //문자여러개는 문자열(String)타입으로 //문자열을 따로 저장되는 메모리공간이 있고, 변수는 그 공간을 가리킴
		
		System.out.println("결과값 확인하기");
		System.out.println("---------------------------");
		//System.out.print()함수 : 출력 후, Enter키 적용x
		//System.out.println()함수 : 출력 후, Enter키 적용 (단축키 : sysout  Ctrl + Space)
		System.out.print(a);
		System.out.println("hello");
		System.out.println(s);
		System.out.println(st);
	} //main메소드가 끝나면 메모리는 초기화

}
