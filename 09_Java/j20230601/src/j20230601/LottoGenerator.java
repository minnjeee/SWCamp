package j20230601;

public class LottoGenerator {
	
	public static int generateNumber() {
		return (int)(Math.random() * 45) + 1;
		// Math.rondom() : 0~1 사이 실수 난수 (1은 미포함)
	}
	
	public static void main(String[] args) {
		int [] lottoNumber = new int[6];
		
		try {
			for(int i=0; i<lottoNumber.length; i++) {
				lottoNumber[i] = generateNumber();
				System.out.print(lottoNumber[i] + ",");
			}
			
			System.out.println(); // Enter 효과 (빈 줄 생성)
			
			for (int n : lottoNumber)
				System.out.printf("%d,", n);
		}
		catch (ArrayIndexOutOfBoundsException e) { //예외발생 시 실행
			System.out.println("오류코드 => " + e);
		}
		finally { //예외발생과 상관없이 무조건 실행
			System.out.println("금주에 이 번호가 행운을 가져다 드릴겁니다~!");
		}
	}
}
