package j20230531;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하시오:");
		int age = scanner.nextInt();
		if(age<10)
			System.out.println("유년기입니다.");
		else if(age<20) {  //age가 20이상 30미만이면
			System.out.print("10대입니다.");
		}
		else if(age<30) {  //age가 20이상 30미만이면
			System.out.print("20대입니다.");
			System.out.println("20대라서 행복합니다!");
		}
		else if(age<40) {  //age가 20이상 30미만이면
			System.out.print("30대입니다.");
		}
		else if(age<50) {  //age가 20이상 30미만이면
			System.out.print("40대입니다.");
		}
		else if(age<60) {  //age가 20이상 30미만이면
			System.out.print("50대입니다.");
		}
		else if(age<70) {  //age가 20이상 30미만이면
			System.out.print("60대입니다.");
		}
		else if(age<80) {  //age가 20이상 30미만이면
			System.out.print("70대입니다.");
		}
		else  //아니면
			System.out.println("실버세대 입니다.");
		scanner.close();
		
	}
}
