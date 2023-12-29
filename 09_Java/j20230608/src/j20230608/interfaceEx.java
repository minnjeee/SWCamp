package j20230608;

public class interfaceEx {

	public static void main(String[] args) {
		SamsungPhone ph = new SamsungPhone();
		
		ph.printLoge();
		ph.sendCall();
		ph.receiveCall();
		ph.flash();
		System.out.println(ph.TIMEOUT);
	}

}
