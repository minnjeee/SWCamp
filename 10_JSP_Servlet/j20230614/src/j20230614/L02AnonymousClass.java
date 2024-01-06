package j20230614;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class L02AnonymousClass {
	public static void main(String[] args) {
		JFrame f = new JFrame("버튼 이벤트 리스터 테스트");
		f.setBounds(0, 0, 300, 300);
		
		JButton btn = new JButton("버튼");
		f.add(btn, BorderLayout.NORTH);
		JLabel label = new JLabel("라벨");
		f.add(label);
		
		//L02AnonymousClass$1.class : ActionListener를 구현한 익명클래스 생성
		/*
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("안녕"); //컴파일러가 지역변수를 전역변수를 변경 취급한다.
				
				
			}
		}); */
		//**개발자들의 불만 : 함수형언어는 함수만 매개변수로 사용하던데 이것도 너무 길고 불편해!!
		//	=> 람다식 : 함수가 1개 있는 인터페이스를 마치 함수를 매개변수로 사용하는 것처럼 작성 가능!
		// 	=> 익명클래스와 아주 유사하게 컴파일러가 구현하지만 클래스를 미리 만들어진 것을 사용하기 때문에 익명클래스가 없다.
		//	=>**함수형언어인척 하는 것 (문법적 설탕, 스태틱슈거?)
		btn.addActionListener(e -> {
			label.setText("람다식 안녕");
		}); //e->{} : public void actionPerformed(ActionEvent e){}를 의미
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
	}
}
