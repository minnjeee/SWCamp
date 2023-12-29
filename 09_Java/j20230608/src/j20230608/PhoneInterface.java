package j20230608;

public interface PhoneInterface extends FiveG,LTE { //인터페이스 간 상속 : extends 사용(다중상속 가능)
	// 인터페이스 내에서는 접근제한자 생략 시 public
	final int TIMEOUT = 10000; //상수 (public 생략)
	void sendCall(); //추상메소드 (public abstract 생략)
	void receiveCall(); //추상메소드
	default void printLoge() { //디폴드메소드 (public 생략)
		System.out.println("** Phone **");
	}
}
