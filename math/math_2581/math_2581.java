package math_2581;

import java.util.Scanner;

/*
 * 문제: 소수
 * 문제 설명: 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 
 * 이들 소수의 합과 최솟값을 찾는 프로그램을 작성.
*/

public class math_2581 {

	public static boolean check(int a) {//소수를 판별하는 함수
		if(a == 0 || a == 1)
			return false;
		
		for(int i =2; i<a; i++) {
			if(a % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int count = 0;
		int sum = 0;
		int min = 0;
		
		while(a<=b) {
			if(check(a) == true) {
				if(count == 0)
					min = a;
				sum+=a;
				count ++;
			}
			a++;
		}
		
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
