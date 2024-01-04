package j20230620;

public class Question03 {
	public static int creatNum(){
		return (int)(Math.random()*45) + 1;
	}
	public static void printNum(){
		int[] lottoNumber = new int[6];
		for(int i=0;i<6;i++) {
			lottoNumber[i] = creatNum();
			
			// 중복 체크
			for(int j=0;j<i;j++) {
				if(lottoNumber[i]==lottoNumber[j]) {
					i--; //같은 값이 있으면 그 위치의 로또번호를 다시 뽑기
					break;
				}
			}
		}
		System.out.println("오늘의 행운의 로또 번호는 ");
		for(int i : lottoNumber) System.out.print(i+" ");
	}
	
	
	public static void main(String[] args) {
		printNum();
	}
}
