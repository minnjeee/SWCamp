package com.scheduler;

public interface Scheduler {
	void getNextCall(); //추상메소드
	void sendCallToAgent(); //추상메소드
}
