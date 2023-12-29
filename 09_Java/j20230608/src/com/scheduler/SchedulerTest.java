package com.scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) {
		System.out.println("전화 상담 배분방식을 선택하세요 ");
		System.out.println("R : 한명씩 차례로 할당");
		System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
		System.out.println("P : 우선순위가 가장 높은 고객 먼저 할당");
		System.out.println("=====>  ");

		try {
			int ch = System.in.read(); // 할당방식을 입력받아 ch변수에 대입
			Scheduler scheduler = null; // 인터페이스 선언 (RoundRobin, LeastJob, PriorityAllocation클래스는 Scheduler인터페이스 속성을 상속받음!)
			
			if (ch == 'R' || ch == 'r') { //문자 하나는 '로 묶고, 문자열은 "로 묶는다!!
				scheduler = new RoundRobin(); //RoundRobin클래스 생성 (업캐스팅!!)
			} else if (ch=='L' || ch=='l') {
				scheduler = new LeastJob(); //LeastJob클래스 생성
			} else if (ch=='P' || ch=='p') {
				scheduler = new PriorityAllocation(); //PriorityAllocation클래스 생성
			} else {
				System.out.println("지원하지 않는 기능입니다.");
				return;
			}
			
			scheduler.getNextCall(); //인터페이스에 선언한 메소드 호출
			scheduler.sendCallToAgent();
		} catch(IOException e) {
			System.out.println("예외발생 => " + e);
		}
	}

}
