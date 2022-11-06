package string_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 숫자의 합
 * 문제 설명: N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성.
*/

public class String_11720 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum =0;
		
		for(int i = 0; i< n; i++) {
			char c = str.charAt(i);
			sum += Character.getNumericValue(c);
		}
		
		System.out.println(sum);
	}

}
