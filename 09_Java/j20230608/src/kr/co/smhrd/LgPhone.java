package kr.co.smhrd;

import j20230608.PhoneInterface;

public class LgPhone implements PhoneInterface {
	//다른 패키지에 있는 인터페이스를 구현할 수 있음
	@Override
	public void sendCall() {
		System.out.println("LG 폰이 없어졌어요....");
	}
	@Override
	public void receiveCall() {
		System.out.println("LG 통신사만 있어요...ㅠ0ㅠ");
	}
	// FiveG 인터페이스의 추상메소드 구현
	@Override
	public void comNet() {System.out.println("LGT의 5G망을 사용하고 있습니다.");}
	// LTE 인터페이스의 추상메소드 구현
	@Override
	public void speed() {System.out.println("LGT Speed는 LTE 속도 입니다.");}

	
	//메소드 추가
	public void ring() {System.out.println("아름다운 음악소리의 전화벨이 울립니다...디리리링...");}
	
}
