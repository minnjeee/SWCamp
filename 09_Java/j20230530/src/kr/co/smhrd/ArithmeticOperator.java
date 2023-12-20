package kr.co.smhrd;

import java.util.Scanner;

public class ArithmeticOperator {

	public static void main(String[] args) {
		Scanner b = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요:"); int time = b.nextInt(); // 초단위 정수 입력
		int second = time % 60; // 초
		int minute = time/60 %60; // 분 (1분 = 60초)
		int hour = time/60 /60; // 시간 (1시간 = 60분)
		
		System.out.println(time + "초는 " + hour + "시간, " + minute + "분, " + second + "초입니다.");
		b.close();

	}

}
