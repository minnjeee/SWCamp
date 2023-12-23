package kr.co.smhrd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutStream {

	public static void main(String[] args) {
		byte b[] = {7, 51, 3, 4, -1, 24};
		
		try {
			FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
			fout.write(b);
			System.out.println("파일을 생성하였습니다");
			fout.close();
		}
		catch(IOException e){
			System.out.println("c:\\Temp\\test.out을 저장 시 오류가 발생하였습니다.");
		}
		
		byte result[] = new byte[6];
		try {
			FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
			int n=0,c;
			while((c=fin.read())!=-1) {
				result[n] = (byte)c;
				n++;
			}
			System.out.println("읽을 배열을 출력");
			for(int i=0; i<b.length; i++)
				System.out.print(b[i]+" ");
			System.out.println();
			fin.close();
		} catch (IOException e) {
			System.out.println("파일 읽기 오류=>" + e);
		}
	}
}
