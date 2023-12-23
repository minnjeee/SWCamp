package kr.co.smhrd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReWriter {

	public static void main(String[] args) {
		// traffic.csv 파일의 내용을 읽어서 c:\Temp\traffic_v2.txt로 저장하기
		FileReader in = null;
		FileWriter fout = null;
		
		try {
			int c;
			in = new FileReader(".\\src\\kr\\co\\smhrd\\traffic.csv");
			fout = new FileWriter("c:\\Temp\\traffic_v2.txt");
			while((c=in.read()) != -1) { // c 에 in에서 읽은 문자의 아스키코드 저장
				fout.write(c); // c에 저장된 아스키코드를 char로 변환하여 fout에 저장
			}
			System.out.println("파일 생성 완료");
			in.close();
			fout.close();
		}
		catch(IOException e) {
			System.out.println("입출력 오류");
		}

	}

}
