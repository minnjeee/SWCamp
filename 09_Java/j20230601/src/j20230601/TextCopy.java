package j20230601;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy {

	public static void main(String[] args) {

		File src = new File("c:\\windows\\system.ini"); //원본파일 경로명
		File dest = new File("c:\\Temp\\system.txt"); //복사파일 경로명
		File destp = new File("c:\\Temp");
		int c;
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while((c=fr.read())!=-1) {
				fw.write((char)c);
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath()+"를 "+dest.getPath()+"로 복사 완료 하였습니다.");
			
			System.out.println("-----"+destp.getPath()+"의 서브 리스트 입니다.-----");
			File[] subFiles = destp.listFiles();
			for(int i=0; i<subFiles.length; i++) {
				File f = subFiles[i];
				long t = f.lastModified();
				System.out.print(f.getName());
				System.out.print("\t파일 크기: "+f.length());
				System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t,t,t,t);
			}
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}

	}

}
