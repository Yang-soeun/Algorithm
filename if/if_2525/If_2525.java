package if_2525;

import java.util.Scanner;

/*
 * 문제명: 오븐 시계
 * 문제 설명: 훈제 오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때,
 * 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성.
 */

public class If_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int a, b, c;
		
		a = in.nextInt();//시
		b = in.nextInt();//분
		c = in.nextInt();//요리하는데 필요한 시간
		
		b = b+c;
		
		while(true) {
			if(b>59) {
				a++;
				b = b-60;
			}
			else if(a>23)
				a = a-24;
			else
				break;
		}
		
		System.out.println(a + " " + b);
		
	}
}
