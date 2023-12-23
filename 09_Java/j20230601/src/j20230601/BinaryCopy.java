package j20230601;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File(".\\resource\\iu.jpg");
		File dest = new File(".\\resource\\myiu.jpg");
		int c;
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while((c=fi.read())!=-1) {
				fo.write(c);
			}
			
			// 고속 복사 부분
//			byte[] buf = new byte[1024*10] //10KB 버퍼
//			while(true) {
//				int n = fi.read(buf); //버퍼크기만큼 읽기. n=실제 읽은 바이트
//				fo.write(buf,0,n); //buf[0]부터 n바이트 쓰기
//				if(n<buf.length)
//					break; // 버터크기보다 작게 읽었으므로 파일 끝에 도달. 복사 완료.
			
			fi.close();
			fo.close();
			System.out.println(src.getPath()+"를 "+dest.getPath()+"로 복사하였습니다.");
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}
