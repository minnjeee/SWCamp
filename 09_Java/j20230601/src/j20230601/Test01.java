package j20230601;

import java.io.File;

public class Test01 {

	public static void main(String[] args) {
		File f = new File("c:\\Program Files\\Java\\jdk-20\\bin");
		File[] subfiles = f.listFiles(); // c:\Temp폴더의 파일 및 서브 폴더 리스트
		
		for (int i=0; i<subfiles.length; i++) {
			System.out.print(subfiles[i].getName()); // 서브 파일/폴더명 출력
			System.out.print("\t파일 크기 : " + subfiles[i].length()); //	서브 파일/폴더 크기(바이트단위) 출력
			System.out.println("\t변경일 : " + subfiles[i].lastModified()); //서브 파일/폴더의 마지막 변경일
		}

	}

}
