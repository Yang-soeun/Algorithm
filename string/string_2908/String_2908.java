package string_2908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제: 상수
 * 문제 설명: 상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
 * 두 수는 같지 않은 세자리 수미여, 0이 포함되어 있지 않다.
 * 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성.
*/

public class String_2908 {
	
	//숫자를 거꾸로 만드는 함수
	public static int newNum(int n) {
		int newNum;
		
		newNum = (n%10)*100 + ((n%100)/10)*10 + n/100;
		
		return newNum;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int newA = newNum(a);
		int newB = newNum(b);
		
		if(newA > newB)
			System.out.println(newA);
		else
			System.out.println(newB);
			
	}

}
