package kr.co.smhrd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment {
	// 과제 : data.go.kr에서 아래의 3개 파일을 다운받아 c:\Temp 폴더에 저장한 후
	//	"서초구 모범음식점 전체 현황.csv" 라는 파일명으로 내용을 통합하여 파일을 생성하시오.
	//서울시 서초구 모범음식점 신청 현황.csv, 서울시 서초구 모범음식점 지정 현황.csv, 서울시 서초구 모범음식점 취소 현황.csv

	public static void main(String[] args) {
		FileReader in = null;
		FileWriter fout = null;
		
		try {
			fout = new FileWriter("c:\\Temp\\서초구 모범음식점 전체 현황.csv");
			int c;
			
			in = new FileReader("c:\\Temp\\one.csv");
			while ((c=in.read()) != -1) {
				fout.write(c);
			}
			in.close();
			System.out.println("신청 현황 통합 완료");
			
			in = new FileReader("c:\\Temp\\two.csv");
			while ((c=in.read())!=-1) {
				fout.write(c);
			}
			in.close();
			System.out.println("지정 현황 통합 완료");
			
			in = new FileReader("c:\\Temp\\three.csv");
			while((c=in.read())!=-1) {
				fout.write(c);
			}
			in.close();
			System.out.println("취소 현황 통합 완료");
			fout.close();
		}catch(IOException e){
			System.out.println("입출력 오류 발생" + e);
		}
	}
}
