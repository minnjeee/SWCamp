package j20230614;

public class L03Thread {
	//throws : 예외를 위임 (다른 함수가 이 함수를 실행할 때 예외처리를 강제, main에서 사용하면 예외처리하지 않겠다는 뜻)
	public static void main(String[] args) throws InterruptedException {
		// Thread = 일꾼
		// main : application -> 일꾼이 1개 있음
		System.out.println("첫번째");
		System.out.println("두번째");
		System.out.println("세번째");
		// 일꾼의 독점 ?? -> ex. 무한루프
		boolean b = true;
		new Thread(()->{ //람다식
			while(b) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("생성된 스레드의 일꾼");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(b) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("두번째 스레드의 일꾼");
				}
				
			}
			
		}).start();
		
		
		while(b) {
			Thread.sleep(1000); //일꾼이 잠시 쉴 수 있게 해줌
			System.out.println("독점당한 일꾼");
		}
		System.out.println("일꾼이 독점당하지 않아다면 실행될 코드");

	}

}
