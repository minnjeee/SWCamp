package kr.co.smhrd;

class Point {
	private int x, y; //멤버필드 2개(동일 클래스에서만 접근가능)
	public Point(int x, int y) { //생성자
		this.x = x; this.y = y;
	}
}
public class ObjectPropertyEx {
	public static void main(String [] args) {
		Point p = new Point(2,3);
		System.out.println(p.getClass().getName()); // 클래스 이름
		System.out.println(p.hashCode()); // 해시 코드 값 -> 실행할 때마다 달라질 수 있음. 그때 그때 객체 생성하기 때문
		System.out.println(p.toString()); // 객체의 문자열
		System.out.println(p);
		
		System.out.println();
		
		Point q = new Point(2,3);
		System.out.println(q.getClass().getName()); // 클래스 이름 (동일)
		System.out.println(q.hashCode()); // 해시 코드 값 (다름, 메모리 위치가 다르기 때문?)
		System.out.println(q.toString()); // 객체의 문자열 (다름)
		
		if(p == q) System.out.println("a==b");
		if(p.equals(q)) System.out.println("a is equal to b");
	}
}