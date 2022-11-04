package math_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 소수 찾기
 * 문제 설명: 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성.
*/

public class Math_1978 {

	public static boolean check(int a) {//소수를 판별하는 함수
		if(a == 0 || a == 1)
			return false;
		
		for(int i =2; i<a; i++) {
			if(a % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int count  = 0;
		
		for(int i = 0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(check(a)== true)
				count ++;
		}
		System.out.println(count);
	}

}
