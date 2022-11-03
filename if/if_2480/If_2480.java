package if_2480;

import java.util.Scanner;

/*
 * 문제: 주사위 세개
 * 문제 설명: 3개의 주사위에 나온 눈이 주어질 때, 상금을 계산하는 프로그램 작성.
*/

public class If_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int a, b, c;//3개의 눈을 저장할 변수.
		int reward = 0;//상금을 저장할 변수
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		
		if(a!=b && b!=c && a!=c) {//모두 다른 경우
			int max = Math.max(a, Math.max(b, c));//3개의 눈 중 가장 큰 눈 고르기
			reward = max*100;
		}
		else if(a == b && b == c && c == a)//모두 같은 경우
			reward = 10000 + (a*1000);
		else if(a==b || a==c || b==c) {//두개만 같은 경우
			int same = a;
			
			if(a == b) 
				same = a;
			else if(b == c)
				same = b;
			
			reward = 1000 + (same*100);
		}
		System.out.println(reward);
	}

}
