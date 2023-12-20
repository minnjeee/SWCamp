package kr.co.smhrd;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요");
		
		Scanner a = new Scanner(System.in); //사용하려면 import해야함(Ctrl+Shift+O :자동으로 import)
		String name = a.next();
		System.out.println("당신의 이름은 " + name + "입니다.");
		String city = a.next();
		System.out.println("당신이 사는 도시는 " + city + "입니다. ");
		int age = a.nextInt();
		System.out.println("당신의 나이는 " + age + "입니다.");
		double weight = a.nextDouble();
		System.out.println("당신의 체중은 " + weight + "입니다.");
		boolean single = a.nextBoolean();
		System.out.println("당신의 독신 여부는 " + single + "입니다.");
		
		System.out.println("----------------------------------------------");
		// 하나하나 입력받는 형식으로 바꿔보기
		System.out.print("이름 : "); name = a.next();
		System.out.print("도시 : "); city = a.next();
		System.out.print("나이 : "); age = a.nextInt();
		System.out.print("체중 : "); weight = a.nextFloat();
		System.out.print("독신 여부 : "); single = a.nextBoolean();
		System.out.println("당신의 이름은 " + name + ", 당신이 사는 도시는 " + city + "입니다.");
		System.out.println("나이가 " + age + "인 당신은 몸무게가 " + weight + "입니다.");
		
		a.close();
	}

}
