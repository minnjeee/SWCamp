package kr.co.smhrd;

import j20230608.SamsungPhone;

public class interfaceEx1 {
	//다른 패키지에서 인터페이스 상속받은 클래스 불러와서 객체 생성하기
	public static void main(String[] args) {
		SamsungPhone ph = new SamsungPhone();
		
		ph.printLoge();
		ph.sendCall();
		ph.receiveCall();
		ph.flash();
		System.out.println(ph.TIMEOUT);
		ph.comNet();
		ph.speed();

		
		LgPhone lgph = new LgPhone();
		
		lgph.printLoge();
		lgph.sendCall();
		lgph.receiveCall();
		lgph.ring();
		System.out.println(lgph.TIMEOUT);
		lgph.comNet();
		lgph.speed();
	}

}
