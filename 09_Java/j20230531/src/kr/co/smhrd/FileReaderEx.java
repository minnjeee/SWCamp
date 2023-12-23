package kr.co.smhrd;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		FileReader in = null;  //파일스트림변수명이 in
		try {
			in = new FileReader(".\\src\\kr\\co\\smhrd\\traffic.csv");
			System.out.println(in.getEncoding());
			// . : 현재 프로젝트 위치
			// \\ : \를 쓰기위해 앞에 \를 붙인 것
			int c; //문자를 읽어 아스키코드로 반환하기 위해 int형으로 선언
			while ((c=in.read()) != -1) { // 파일 끝을 만나면 -1 리턴 => 한 문자씩 파일 끝까지 읽음!
				System.out.print((char)c); // 아스키코드를 문자형으로 출력
			}
			in.close();
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
