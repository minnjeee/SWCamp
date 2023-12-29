package j20230609;

import java.util.Iterator;
import java.util.Vector;

public class VertorEx {

	public static void main(String[] args) {
		// 정수 값만 다루는 제네릭 벡터 생성 (정수 객체들을 모아놓는 공간)
		Vector<Integer> v = new Vector<Integer>(); //디폴트 용량 = 10
		// 요소 삽입
		v.add(5); // 5 삽입
		v.add(4); // 4 삽입
		v.add(-1); // -1 삽입
		v.add(2, 100); // 2번째 위치인 4와 -1 사이에 정수 100 삽입
		System.out.println("벡터 내의 요소 객체 수 : " + v.size()); //요소 수
		System.out.println("벡터의 현재 용량 : " + v.capacity()); //설정한 용량
		
		// 모든 요소 정수 출력하기
		for(int i=0; i<v.size(); i++) {
			int n = v.get(i); // 벡터의 i 번째 정수
			System.out.println(n);
		}
		// 벡터 속의 모든 정수 더하기
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			int n = v.elementAt(i); // 벡터의 i 번째 정수
			sum += n;
		}
		System.out.println("벡터에 있는 정수 합 : " + sum);

		Iterator<Integer> it = v.iterator(); // Vector 객체 얻어오기(공유하기)
		int sum2 = 0;
		while(it.hasNext()) {
			int n = it.next();
			System.out.println(n);
			sum2 += n;
		}
		System.out.println("합계는 " + sum2);
	}

}
