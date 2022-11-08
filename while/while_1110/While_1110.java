package while_1110;

import java.util.Scanner;

/*
 * 문제: 더하기 사이클
 * 문제 설명: N이 주어졌을때, N의 사이클의 길이를 구하는 프로그램 작성.
 */

public class While_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n;
		int newNum;
		int sum = 0, cycle = 0;
		
		n = in.nextInt();
		newNum = n;
		
		while(true) {
			if(newNum <10) {//10보다 작은경우
				if(n == 0) {
					cycle = 1;
					break;
				}
				else {
					sum = newNum;
					newNum = (newNum%10)*10+sum;
					cycle++;
					
					if(newNum == n)//같으면 종료
						break;
				}
			}
			
			if(newNum >=10) {//10 이상인 경우
				sum = newNum/10 + newNum%10;//각 자리의 수를 더한다.
				newNum = (newNum%10)*10 + sum%10;
				cycle ++;
				
				if(newNum == n)
					break;
			}
		}
		
		System.out.println(cycle);
	}

}
