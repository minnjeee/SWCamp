package j20230609;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String query = "name=minjee&addr=seoul&age=26";
		StringTokenizer st = new StringTokenizer(query, "&=");
		
		int n = st.countTokens(); // 토큰 개수
		System.out.println("토큰 개수 = " + n);
		
		while(st.hasMoreTokens()) { //다음 토큰 존재 여부
			String token = st.nextToken(); // 다음 토큰 얻기
			System.out.println(token);
		}
		
		///////////////////////////////////////////////////
		
		System.out.println(Math.abs(-3.14)); // 절대값
		System.out.println(Math.sqrt(9.0)); // 제곱근
		System.out.println(Math.exp(2)); // e의 2승
		System.out.println(Math.round(3.54)); // 반올림
		System.out.print("이번주 행운의 번호는 ");
		for (int i=0;i<5;i++) System.out.print((int)(Math.random()*45+1)+ " "); //0~45 난수 발생

	}

}
