package kr.co.smhrd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment {
	// ���� : data.go.kr���� �Ʒ��� 3�� ������ �ٿ�޾� c:\Temp ������ ������ ��
	//	"���ʱ� ��������� ��ü ��Ȳ.csv" ��� ���ϸ����� ������ �����Ͽ� ������ �����Ͻÿ�.
	//����� ���ʱ� ��������� ��û ��Ȳ.csv, ����� ���ʱ� ��������� ���� ��Ȳ.csv, ����� ���ʱ� ��������� ��� ��Ȳ.csv

	public static void main(String[] args) {
		FileReader in = null;
		FileWriter fout = null;
		
		try {
			fout = new FileWriter("c:\\Temp\\���ʱ� ��������� ��ü ��Ȳ.csv");
			int c;
			
			in = new FileReader("c:\\Temp\\one.csv");
			while ((c=in.read()) != -1) {
				fout.write(c);
			}
			in.close();
			System.out.println("��û ��Ȳ ���� �Ϸ�");
			
			in = new FileReader("c:\\Temp\\two.csv");
			while ((c=in.read())!=-1) {
				fout.write(c);
			}
			in.close();
			System.out.println("���� ��Ȳ ���� �Ϸ�");
			
			in = new FileReader("c:\\Temp\\three.csv");
			while((c=in.read())!=-1) {
				fout.write(c);
			}
			in.close();
			System.out.println("��� ��Ȳ ���� �Ϸ�");
			fout.close();
		}catch(IOException e){
			System.out.println("����� ���� �߻�" + e);
		}
	}
}
