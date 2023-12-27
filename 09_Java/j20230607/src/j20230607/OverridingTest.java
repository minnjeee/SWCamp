package j20230607;

class A{
	void f() {
		System.out.println("A의 f() 호출");
	}
}
class B extends A{
	void f() { //A의 f()를 오버라이딩
		System.out.println("B의 f() 호출");
	}
}

public class OverridingTest {

	public static void main(String[] args) {
		A a = new A();
		a.f();
		
		A a1 = new B(); // 업캐스팅
		a1.f(); // 동적 바인딩ㅎ
		
//		B b = (B)a; // 다운캐스팅
//		b.f();
		
		B b1 = new B();
		b1.f();
	}

}
