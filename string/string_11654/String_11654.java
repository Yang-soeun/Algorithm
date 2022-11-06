package string_11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 아스키 코드
 * 문제 설명: 알파벳 소문자, 대문자, 숫자 0-9 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성.
*/
public class String_11654 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c = br.readLine().charAt(0);
		int i = c;
		
		System.out.println(i);
	}
}
