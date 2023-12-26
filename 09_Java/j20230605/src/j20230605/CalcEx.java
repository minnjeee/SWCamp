package j20230605;

class Calc{
	//static멤버 -> Shared Data 공간에 생성
	//non-static멤버 -> 객체 생성되어야 생성
	int n; //non-static 멤버필드 선언
	static int m; //static 멤버필드 선언
	void f1(int x) { //non-static 멤버메서드
		n = x;
	}
	void f2(int x) { //non-static 멤버메서드
		m = x;
	}
//	static void s1(int x) { //static 멤버메서드
//		n = x; // 오류
//	}
//	static void s2(int x) { //static 멤버메서드
//		f1(3); //오류
//	}
	static void s3(int x) {
		m = x;
	}
	static void s4(int x) {
		s3(3);
	}
	
	public static int abs(int a) { return a>0?a:-a; }
	public static int max(int a, int b) { return (a>b)?a:b; }
	public static int min(int a, int b)	{ return (a>b)?b:a; }
}



public class CalcEx {

	public static void main(String[] args) {
		System.out.println(Calc.abs(-5)); //static변수는 객체 생성 필요 없음!
		System.out.println(Calc.max(10,8));
		System.out.println(Calc.min(-3,8));
		
		//객체 생성 전
//		Calc.n = 10; //인스턴스 변수 접근 불가(아직 메모리공간에 생성x)
		Calc.m = 20; //클래스 변수 사용 가능(메모리 Shared Data공간에 생성됨)
//		f1(50);
//		f2(50);
		// 객체 생성 후
		Calc cal = new Calc();
		cal.n = 10;
		cal.m = 30;
		cal.f1(50);
		cal.f2(50);

	}

}
