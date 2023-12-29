package j20230609;

class GStack<T> {
	int tos; 
	Object [] stck;
	public GStack() {
		tos = 0; //TOP위치
		stck = new Object [10]; //stack 공간 10개
	}
	public void push(T item) {
		if(tos == 10) //TOP이 맨 위이면 (stack공간이 다 찼으면)
			return; //종료
		stck[tos] = item; //아니면 stack의 TOP위치에 데이터 넣기(PUSH연산)
		tos++; //TOP = TOP + 1
	}
	public T pop() {
		if(tos == 0) //TOP이 제일 밑이면 (stack공간에 데이터가 없으면)
			return null; //null반환
		tos--; //아니면 TOP = TOP-1
		return (T)stck[tos]; //stack의 TOP위치에 있는 데이터 꺼내기(POP연산)
	}
}


public class MyStack {

	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>(); //(TOP=0)
		stringStack.push("seoul"); // seoul데이터 넣기 (TOP=1)
		stringStack.push("busan"); // busan데이터 넣기 (TOP=2)
		stringStack.push("LA"); // LA데이터 넣기 (TOP=3)
		for(int n=0; n<3; n++) 
			System.out.println(stringStack.pop()); //데이터3개(LA, busan, seoul)데이터 꺼내기(TOP=0)
		GStack<Integer> intStack = new GStack<Integer>(); 
		intStack.push(1); // TOP위치(=0)에 1데이터 넣기 (TOP=1)
		intStack.push(3); // TOP위치에 2데이터 넣기 (TOP=2)
		intStack.push(5); // TOP위치에 3데이터 넣기 (TOP=3)
		for(int n=0; n<3; n++)
			System.out.println(intStack.pop()); //데이터3개(3,2,1)꺼내기 (TOP=0)

	}

}

// 그래프에서 한 번씩 모든 노드에 방문할 때, stack구조, queue구조 이용
// stack구조는 방문한 곳에서 다른 곳으로 방문할 때, 방문한 곳을 stack에 넣고, 다시 돌아갈 때 stack에서 꺼내면서 왔던 곳으로 이동
// queue구조는 그래프를 계층으로 나눠서, 상위에서 하위를 방문할 때, queue에서 상위를 꺼내고, 하위들을 넣으면서 밑으로 이동















