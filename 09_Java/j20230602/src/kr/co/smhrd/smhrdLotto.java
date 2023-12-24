package kr.co.smhrd;

import java.util.Random;
import java.util.Scanner;

import j20230602.LottoGenerator; //패키지명.클래스명
public class smhrdLotto {

	public static void main(String[] args) {
		System.out.println("아래에 오늘 날짜를 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		String dateSt = sc.next();
		
		LottoGenerator ltNum = new LottoGenerator(); //다른 패키지의 클래스를 ltNum으로 선언과 생성
		
//		int number = ltNum.generateNumber(); //패키지명.함수명
//		System.out.println(number);
		
		ltNum.lottoPrint();
		
		
		System.out.println("---------------------------------------------------");
		
		Random rd = new Random(); //랜덤 객체 선언 및 생성
//		System.out.println(rd.nextInt(45)+1); //랜덤객체.nextInt(n) : 0~(n-1)의 정수에서 랜덤하게 난수 생성
		try{
			int[] lottoNumber = new int[6];
			for(int i=0;i<6;i++) {
				lottoNumber[i] = rd.nextInt(45)+1 ;
				
				// 중복 체크
				for(int j=0;j<i;j++) {
					if(lottoNumber[i]==lottoNumber[j]) {
						i--;
						break;
					}
				}
			}
			for (int n : lottoNumber)
				System.out.printf("%d ", n);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("----------다음의 오류 발생되었습니다---------");
			System.out.println(e);
		}
		
		
	}

}
