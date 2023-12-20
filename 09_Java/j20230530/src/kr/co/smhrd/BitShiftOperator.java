package kr.co.smhrd;

public class BitShiftOperator {

	public static void main(String[] args) {
		short a = (short)0x55ff;
		short b = (short)0x00ff;
		
		//비트 연산
		System.out.println("[비트 연산 결과]");
		System.out.printf("%04x\n", (short)a & b); // 비트 &연산
		System.out.printf("%04x\n", (short)a | b); // 비트 |연산
		System.out.printf("%04x\n", (short)a ^ b); // 비트 ^연산
		System.out.printf("%04x\n", (short)~a); // 비트 ~연산
		//System.out.printf("출력 서식", 출력할 내용);
		// 출력 서식 : %[-][0][전체자리수][.소수점아래자리수]지시자
		// 지시자 : b(논리),d(정수),o(8진수),x(16진수),f(실수),c(문자),s(문자열),n(줄바꿈),e(지수형식)
		// 0 : 전체 자리수가 지정되면 남은 공백에 0을 대입
		// - : 전체 자리수가 지정되면 왼쪽 정렬하고 오른쪽 빈칸에 공백 (기본값 : 오른쪽 정렬)
		// 따라서, System.out.printf("%04x\n",); => 16진수로, 전체 4자리, 공백은 0으로 채워서 
		
		byte c = 20; //0x14
		byte d = -8; //0xf8
		//시프트 연산
		System.out.println("[시프트 연산 결과]");
		System.out.println(c<<2); // c를 왼쪽으로 2번 시프트(c * 4 의 효과)
		System.out.println(c>>2); // c를 오른쪽으로 2번 시프트, 양수이므로 0삽입(c / 4의 효과)
		System.out.println(d >> 2); // d를 오른쪽으로 2비트 시프트, 음수이므로 1삽입
		System.out.printf("%x\n",(d>>>2)); //d를 오른쪽으로 2비트 시프트, 0삽입(나누기 효과는 없음)
		
	}

}
