package j20230620;

import java.io.IOException;

interface Scheduler{
	void getNextCall();
	void sendCallToAgent();
}

class RoundRobin implements Scheduler{
	@Override
	public void getNextCall() {
		System.out.println("상담 전화 가져오기");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("다음 순서 상담원에게 배분");
	}
}

class LeastJob implements Scheduler{
	@Override
	public void getNextCall() {
		System.out.println("상담 전화 가져오기");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("현재 상담 업무가 없거나 상담 대기가 가장 적은 상담원에게 배분");
	}
}

class PriorityAllocation implements Scheduler{
	@Override
	public void getNextCall() {
		System.out.println("고객의 등급이 높은 고객의 전화");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("업무 skill이 가장 높은 상담원의 대기열에 앞에 우선 배분");
	}
}

public class SchedulerTest {
	public static void main(String[] args) {
		System.out.println("전화 상담 배분방식을 선택하세요 ");
		System.out.println("R : 한명씩 차례로 할당");
		System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
		System.out.println("P : 우선순위가 높은 고객 먼저 할당");
		System.out.println("====> ");
		try {
			int ch = System.in.read();
			
			Scheduler scheduler = null;
			if( ch=='R' || ch=='r') {scheduler = new RoundRobin();}
			else if (ch=='L' || ch=='l') {scheduler = new LeastJob();}
			else if (ch=='P' || ch=='p') {scheduler = new PriorityAllocation();}
			else {
				System.out.println("지원하지 않는 기능입니다.");
				return;
			}
			
			scheduler.getNextCall();
			scheduler.sendCallToAgent();
		} catch (IOException e) {
			System.out.println("예외발생 => " + e);
		}
	}
}
