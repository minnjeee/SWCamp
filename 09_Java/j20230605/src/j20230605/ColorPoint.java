package j20230605;

class Point{
	private int x,y; //Point클래서 내부에서만 접근 가능(private)
	public Point() {
		this.x = this.y = 0;
	}
	public Point(int x, int y) { //생성자(객체 생성 시 자동 실행)
		this.x = x; this.y = y;
	}
	public void showPoint() {
		System.out.println("("+x+","+y+")");
	}
}

public class ColorPoint extends Point {
	private String color;
	public ColorPoint(int x, int y, String color) {
		super(x,y); //슈퍼클래스(Point)의 Point(x,y)생성자 호출
		this.color = color;
	}
	public void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}
