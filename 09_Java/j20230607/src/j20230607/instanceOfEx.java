package j20230607;

class Person {
	String name; //이름 멤버필드
	int age; //나이 멤버필드
	public void pPrint() { //이름,나이 출력하는 멤버메소드
		System.out.println("name = " + name + ", age = "+ age);
	}
	public Person() { //기본생성자
		name = "스마트";
		age = 20;
	}
	public Person(String name, int age) { //생성자 오버로딩(Overloading)
		this.name = name;
		this.age = age;
	}
}
class Student extends Person {
	String grade; //학점 멤버필드
	public void setGrade(String grade) { //학점필드에 값 대입 멤버메소드
		this.grade = grade;
	}
	public void sPrint() { //이름,나이,학점 출력하는 멤버메소드
		pPrint();
		System.out.println("grade = " + grade);
	}
	public Student() { //생성자
		super("김민지",26); //슈퍼클래스 Person의 2번째 생성자 호출
	}
}
class Researcher extends Person {
	String department; //학과 멤버필드
	public void setDepartment(String department) { //학과필드에 값 대입하는 멤버메소드
		this.department = department;
	}
	public void rPrint() { //이름,나이,학과 출력하는 멤버메소드
		pPrint();
		System.out.println("department = " + department);
	}
	public Researcher() { //생성자
		super(); 		//슈퍼클래스 Person의 기본생성자 호출
	}
}
class Professor extends Researcher {
	String gender; //성별 멤버필드
	public void setGender(String gender) { //성별필드에 값 대입 멤버메소드
		this.gender = gender;
	}
	public void fPrint() { //이름,나이,학과,성별 출력하는 멤버메소드
		rPrint();
		System.out.println("gender = " + gender);
	}
	public Professor() { //생성자
		super();		//슈퍼클래스 Researcher의 기본생성자 호출
	}
}


public class instanceOfEx {
	static void print(Person p) {
		// 객체레퍼런스 instanceof 클래스타입 -> true/false
		// 문자열 instanceof String
		if(p instanceof Person)
			System.out.print("Person ");
		if(p instanceof Student)
			System.out.print("Student ");
		if(p instanceof Researcher)
			System.out.print("Researcher ");
		if(p instanceof Professor)
			System.out.print("Professor ");
		System.out.println();
	}

	public static void main(String[] args) {
		Person pe;
		Student st = new Student();
		pe = st; //업캐스팅(슈퍼클래스 레퍼런스에 서브클래스 레퍼런스 대입)
		st.setGrade("A");
		st.sPrint();
		
		pe.name = "캠프반 화이팅";
		pe.age = 21;
		pe.pPrint();
//		pe.setGrade("B");
		st.setGrade("B"); //업캐스팅된 객체 pe는 자신의 속성과 메소드에만 접근 가능(pe.setGrade("B");불가) => st객체를 이용할 것
		st.sPrint();
		
		
		Researcher rs = new Researcher();
		Professor pf = new Professor();
		
		pf.setGender("여자");
		pf.setDepartment("빅데이터분석");
		pf.fPrint();
		
		rs = pf; //업캐스팅
		pe = pf; //업캐스팅
//		st = pf; //pf는 st를 상속받지 않음 (업캐스팅 불가)
//		rs.setGender("여자"); //setGender는 Professor객체의 메소드 => 슈프클래스Researcher는 접근 불가
//		rs.fPrint();
		rs.setDepartment("빅데이터분석");
		rs.rPrint();
		rs.pPrint();
		
//		pe.setGender("여자"); //Professor와 Researcher 객체의 필드와 메소드는 슈퍼클래스Person이 접근 불가
//		pe.setDepartment("빅데이터분석");
//		pe.fPrint();
//		pe.rPrint();
		pe.pPrint();
		
		System.out.print("new Student() -> "); print(st);
		System.out.print("new Researcher() -> "); print(rs);
		System.out.print("new Professor() -> "); print(pf);
	}

}
