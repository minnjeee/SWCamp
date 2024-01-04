package j20230620;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {
	public static void main(String[] args) {
		FileReader fin;
		FileWriter fout;
		InputStreamReader in = new InputStreamReader(System.in);
		int c;
		
		try {
			fout = new FileWriter("c:\\temp\\smart02.csv");
			while ((c=in.read())!=-1) {
				fout.write(c);
			}
			System.out.println("c:\\temp\\smart02.csv 파일이 생성되며 입력한 내용이 저장 되어 있다.");
			in.close();
			fout.close();
			
			fout = new FileWriter("c:\\temp\\smart03.txt");
			fin = new FileReader("c:\\temp\\smart02.csv");
			while ((c=fin.read()) != -1) {
				fout.write(c);
			}
			System.out.println("c:\\temp\\smart03.txt 파일이 생성되며 입력한 내용이 저장 되어 있다.");
			fin.close();
			fout.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
