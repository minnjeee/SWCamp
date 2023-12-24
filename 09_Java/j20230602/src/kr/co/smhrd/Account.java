package kr.co.smhrd;

import java.util.Scanner;

//미션 : 은행 계좌 만들기

public class Account {
	//필드
	private int id; //번호
	private String password; //비번
	private String ownerName; //소유자이름
	private int balance; //잔액
	//메소드
	public void deposit(int d) { //입금 함수
		balance += d;
		System.out.println("-----"+d+"원이 입금되었습니다.-----");
	}
	public int withdraw(int w, String p) { //출금 함수
		if(this.isCorrectPassword(p)) {
			balance -= w;
			System.out.println("-----"+w+"원이 출금되었습니다.-----");
		} 
		else 
			System.out.println("-----비밀번호가 틀립니다.-----");
		return balance;
	}
	public int checkBalance(String p) { //잔액 체크 함수
		if(isCorrectPassword(p))
			return balance;
		else
			return 0;
	}
	private boolean isCorrectPassword(String p) { //패스워드 체크 함수
		if(password == p)
			return true;
		else
			return false;
	}
	//생성자
	public Account(int i, String p, String n) {
		id = i;
		password = p;
		ownerName = n;
	}
	
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("-----생성할 계좌 정보를 입력하세요-----");
		System.out.println("아이디 : "); int id = a.nextInt();
		System.out.println("비밀번호 : "); String password = a.next();
		System.out.println("이름 : "); String userName = a.next();
		
		Account account = new Account(id, password, userName); // 계좌 생성
		
		while(true) {
			System.out.println("-----1.입금 2.출금 3.잔액조회 4.종료-----");
			int num = a.nextInt();
			if(num==1) {
				System.out.println("입금 : "); int d = a.nextInt();
				account.deposit(d);
			}
			else if (num==2) {
				System.out.println("출금 : "); int w = a.nextInt();
				System.out.println("비밀번호 : "); password = a.next();
				account.withdraw(w, password);
			}
			else if (num==3) {
				System.out.println("비밀번호 : "); password = a.next();
				System.out.println("잔액 : " + account.checkBalance(password));
			}
			else if (num==4) {
				System.out.println("-----종료되었습니다-----");
				break;
			}
		}
		a.close();
	}

}
