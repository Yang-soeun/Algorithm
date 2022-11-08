package while_10952;

import java.util.Scanner;

/*
 * 문제: A+B-5
 * 문제 설명: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성.
*/

public class While_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
	
		int a, b;
	
		a = in.nextInt();
		b = in.nextInt();
		
		while(a!=0 || b!=0) {
			System.out.println(a+b);		
			a = in.nextInt();
			b = in.nextInt();
		}
	}
}