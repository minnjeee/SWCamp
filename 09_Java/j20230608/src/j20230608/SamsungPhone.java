package j20230608;

public class SamsungPhone implements PhoneInterface {
	// PhoneInterface 인터페이스의 추상메소드 구현
	@Override
	public void sendCall() {
		System.out.println("띠리리리링");
	}
	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다.");
	}
	// FiveG 인터페이스의 추상메소드 구현
	@Override
	public void comNet() {System.out.println("5G망을 사용하고 있습니다.");}
	// LTE 인터페이스의 추상메소드 구현
	@Override
	public void speed() {System.out.println("Speed는 LTE 속도 입니다.");}

	// 클래스의 멤버 메소드 추가 작성
	public void flash() {
		System.out.println("전화기에 불이 켜졌습니다.");
	}
}
