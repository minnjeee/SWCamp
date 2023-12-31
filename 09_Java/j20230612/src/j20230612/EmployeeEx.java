package j20230612;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Employee {
	String name;
	int[] hours;
	Employee(String name, int[] hours){ //생성자
		this.name = name;
		this.hours = hours;
	}
	int totalHours() {
		int sum = 0;
		for(int i:hours) {
			sum += i;
		}
		return sum;
	}
}



public class EmployeeEx {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int num = s.nextInt(); //직원 수 입력
		int h[][] = new int[num][7];
		String name[] = new String[num];
		Employee[] arr = new Employee[num];
		
		for (int i=0; i<num; i++) {
			name[i] = s.next(); //직원 이름
			for (int j=0;j<7;j++) {
				h[i][j] = s.nextInt(); //근무한 시간
			}
			arr[i] = new Employee(name[i], h[i]);
		}
		Arrays.sort(arr, Comparator.comparingInt(Employee::totalHours).reversed());
		for(int i=0;i<num;i++) {
			System.out.println(arr[i].name + " " + arr[i].totalHours());
		}
		s.close();
	}
}
