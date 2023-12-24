package kr.co.smhrd;


class CircleIn{ // 다른 패키지?에서 사용 불가
	int radius; //멤버 필드
	public double getArea() { //멤버 메소드
		return 3.14 * radius * radius;
	}
	
	public CircleIn(int radius) { //생성자
		this.radius = radius;
	}
}


public class CircleArray {
	
	public static void Saprint() {
		System.out.println("이 함수는 Saprint()함수이고, CircleArray클래스 안에 있습니다.");
	}

	public static void main(String[] args) {
		CircleIn [] c; //객체배열에 대한 레퍼런스 변수c 선언
		c = new CircleIn[5]; //배열 생성
		
		for(int i=0;i<c.length;i++) //배열의 원소에 객체 생성
			c[i] = new CircleIn(i);
		
		for(int i=0; i<c.length; i++)
			System.out.print((int)(c[i].getArea()) + " ");
	}

}
