package j20230601;

//과제 : LottoGenerator가 추출한 번호에 중복값이 있는지 확인하고 
//	중복값이 존재하면 번호 생성을 다시 반복해서 중복되지 않은 값 6개 숫자를 출력하는 소스 작성하기

public class Assignment {
	
	public static int generateNumber() {
		return (int)(Math.random() * 45) + 1;
	}

	public static void main(String[] args) {
		int [] lottoNumber = new int[6]; //로또번호 담을 정수형 배열 생성
		
		for(int i=0; i<lottoNumber.length; i++) {
			boolean b = true;
			while(b) {
				lottoNumber[i] = generateNumber(); // 로또 번호 생성
				if (i==0) // 첫번째 로또번호는 비교할 것이 없으므로 while문에서 나가기
					break;
				
				for(int j=0; j<i; j++) { // 이전에 뽑은 로또번호와 동일한 값이 있는지 확인
					if (lottoNumber[j] == lottoNumber[i]) { // 동일한 값이 있으면
						System.out.println((i+1) + "번째 로또번호가 "+ (j+1) +"번째 로또번호랑 같다. => " + lottoNumber[j]);
						break; //for문을 나가서 while문에서 다시 로또번호 생성 후 비교
					}
					else if (j == i-1) // 동일한 값이 없으면
						b = false; // while문 안의 조건식에 false를 주어 while문 끝내기
				}
			}
		}
		
		for (int i : lottoNumber)
			System.out.print(i+" ");
	}

}
