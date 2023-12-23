package kr.co.smhrd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReWriter {

	public static void main(String[] args) {
		// traffic.csv ������ ������ �о c:\Temp\traffic_v2.txt�� �����ϱ�
		FileReader in = null;
		FileWriter fout = null;
		
		try {
			int c;
			in = new FileReader(".\\src\\kr\\co\\smhrd\\traffic.csv");
			fout = new FileWriter("c:\\Temp\\traffic_v2.txt");
			while((c=in.read()) != -1) { // c �� in���� ���� ������ �ƽ�Ű�ڵ� ����
				fout.write(c); // c�� ����� �ƽ�Ű�ڵ带 char�� ��ȯ�Ͽ� fout�� ����
			}
			System.out.println("���� ���� �Ϸ�");
			in.close();
			fout.close();
		}
		catch(IOException e) {
			System.out.println("����� ����");
		}

	}

}
