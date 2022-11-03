package array_8958;

import java.util.Scanner;

/*
 * 문제: OX 퀴즈
 * 문제 설명: O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
 * OX 퀴즈의 결과가 주어졌을때, 점수를 구하는 프로그램을 작성
*/

public class Array_8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String[] testcase = new String[n];
		
		for(int i =0; i<n; i++) {
			testcase[i] = in.next();
		}
		
		int j=0;
		int score, totalscore;
		
		while(j <n) {
			String str = testcase[j];
			int len = str.length();
			score =0; totalscore =0;
			
			for(int k = 0; k<len; k++) {
				if(str.startsWith("O")) {
					score++;
					totalscore += score;
					str = str.substring(1);
				}
				else {
					score =0;
					str = str.substring(1);
				}
			}
			
			j++;
			System.out.println(totalscore);
		}
	}
}
