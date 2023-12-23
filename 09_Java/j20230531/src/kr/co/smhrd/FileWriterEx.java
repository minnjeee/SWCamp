package kr.co.smhrd;

//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterEx {
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\test.txt", true);
			System.out.println("파일에 입력할 내용을 적어주세요.");
			while ((c=in.read())!=-1) {
				fout.write(c);
			}
			System.out.println("파일 입력이 완료되었습니다. 파일 생성여부를 확인해 주세요~");
			in.close();
			fout.close();
			
			// 밑에 부분은 연습하는 부분 : 배열을 이용해서 읽어보기
//			FileReader fin = new FileReader("c:\\Temp\\test.txt");
//			char[] check = new char[50];
//			int c2 = fin.read(check,0,10);
//			System.out.println(c2);
//			for (int i=0; i<10; i++) {
//				System.out.print(check[i]);
//			}
//			fin.close()
		}
		catch(IOException e){
			System.out.println("입출력 오류");
		}
	}
}
