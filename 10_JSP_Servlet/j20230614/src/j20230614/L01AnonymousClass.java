package j20230614;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// class : 객체의 타입 (객체를 추상화 한 것)
// abstract class : class를 추상화 한 것 (class가 되다 만 것)
// interface : 만들 클래스의 실행의 구조(추상함수)만 정의 한 것
// **추상메서드가 있으면 덜 구현되어 있어 객체가 될 수 없다.

class BtnApp {
	JLabel label; //전역변수
	
	class BtnHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("안녕");
		}
	}
	//**함수를 매개변수로(콜백함수) 사용하기 위해 타입을 정의하는 것은 시간과 돈이 낭비된다.(생산성 감소)
	//**자바 컴파일러가 타입 정의하고 구현하는 거 대신해줄께 -> 익명클래스! (내부클래스+이름이 숫자)
	public void run(String[] args) {
		JFrame f = new JFrame("버튼 이벤트 리스터 테스트");
		f.setBounds(0, 0, 300, 300);
		
		JButton btn = new JButton("버튼"); //지역변수
		f.add(btn, BorderLayout.NORTH);
		label = new JLabel("라벨");
		f.add(label);
		
		//**자바는 함수를 매개변수로 사용 불가능 (기본형 or 자료형) //ex) btn.addActionListener(new BtnHandler());

		//**자바의 함수는 객체일 수 없음 (함수형 언어는 함수를 객체로 만들 수 있다? - 그때 함수를 콜백함수라 부름)
		//내부클래ㅡㅅ에서 클래스를 객체로 불가?
//		L01AnonymousClass anonymousClass = new L01AnonymousClass();
		btn.addActionListener(new BtnHandler());
		
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //f.setDefaultCloseOperation(2);와 동일
		
	}
}

public class L01AnonymousClass{
	public static void main(String[] args) {
		BtnApp btnApp = new BtnApp();
		btnApp.run(args);
	}
}
