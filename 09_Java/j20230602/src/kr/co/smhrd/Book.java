package kr.co.smhrd;

public class Book {
	String title; //필드
	String author; //필드
	void show() { System.out.println(title + " " + author); } //메서드
	
	public Book() { //생성자1
		this("",""); //생성자3호출, this() : 생성자 호출을 의미
		System.out.println("생성자 호출됨");
	} //기본생성자 (다른 생성자 생성 시, 기본생성자를 사용하려면 앞에 먼저 만들어줘야함)
	public Book(String t) { // 생성자2
		this(t, "작가미상"); //생성자3호출
	}
	public Book(String title, String author) { // 생성자3
		this.title = title; //this : 객체를 의미
		this.author = author;
	}
	
	public static void main(String [] args) {
		Book javaBook = new Book("Java", "황기태"); // 생성자3 호출
		javaBook.show();
		
		Book bible = new Book("Bible"); // 생성자2 호출
		bible.show();
		
		Book emptyBook = new Book(); // 생성자1 호출
		emptyBook.show();
	}
}
