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
			System.out.println("���Ͽ� �Է��� ������ �����ּ���.");
			while ((c=in.read())!=-1) {
				fout.write(c);
			}
			System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�. ���� �������θ� Ȯ���� �ּ���~");
			in.close();
			fout.close();
			
			// �ؿ� �κ��� �����ϴ� �κ� : �迭�� �̿��ؼ� �о��
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
			System.out.println("����� ����");
		}
	}
}
