package j20230609;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapDicEx {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		// 3 개의 (key, value) 쌍을 dic에 저장
		dic.put("baby", "아기"); // "baby"는 key, "아기"은 value
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		// dic 해시맵에 들어 있는 모든 (key, value) 쌍 출력
		Set<String> keys = dic.keySet(); // 모든 키를 Set 컬렉션에 받아옴 (Set은 중복 허용x, 집합 개념)
		Iterator<String> it = keys.iterator(); // Set에 접근하는 Iterator 리턴
		while(it.hasNext()) {
			String key = it.next(); // 키
			String value = dic.get(key); // 값
			System.out.print("(" + key + "," + value + ")");
		}
		System.out.println();
		
		// 영어 단어를 입력받고 한글 단어 검색
		Scanner scanner = new Scanner(System.in);
		while(true) { // for(int i=0; ; i++) 가운데 조건을 생략하면 무한반복 가능!!
			System.out.print("찾고 싶은 단어는?(종료:0)");
			String eng = scanner.next();
			
			if(eng.equals("0")) {
				System.out.println("사전 종료.");
				break;
			}
			
			// 해시맵에서 '키' eng의 '값' kor 검색
			String kor = dic.get(eng);
			if(kor == null) 
				System.out.println(eng + "는 없는 단어 입니다.");
			else 
				System.out.println(kor);
		}
		scanner.close();
	}

}
