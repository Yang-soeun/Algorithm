package if_1330;

import java.util.Scanner;

/*
 * 문제: 두 수 비교하기
 * 문제 설명: 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램
 */
public class If_1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		if(a > b)
			System.out.println(">");
		else if (a < b)
			System.out.println("<");
		else if (a == b)
			System.out.println("==");
	}
}
