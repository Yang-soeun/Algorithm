package math_1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 손익분기점
 * 문제 설명: 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점이라고 한다.
 * A, B, C가 주어졌을때, 손익분기점을 구하는 프로그램을 작성. 
*/

public class Math_1712 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(C <= B)
			System.out.println(-1);
		else 
			System.out.println((A/(C-B)) + 1);
		}
}
