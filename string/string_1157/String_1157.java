package string_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 단어 공부
 * 문제 설명: 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성.
 * 단, 대문자와 소문자를 구분하지 않는다.
*/

public class String_1157 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] big_array = new int[26];
		int[] small_array = new int[26];
		
		String str = br.readLine();
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) < 97) {//대문자인 경우
				int index = str.charAt(i) - 65;
				big_array[index] +=1;
			}
			else {//소문자인 경우
				int index = str.charAt(i) - 97;
				small_array[index] +=1;
			}
		}
		
		//두 배열 합치기
		for(int i = 0; i< big_array.length; i++) {
			big_array[i] += small_array[i];
		}
		
		//젤 많이 사용된 알파벳 구하기
		int max = -1;
		int same = 0;
		char c = ' ';
		
		for(int i = 0; i<big_array.length; i++) {
			if(max == big_array[i])
				same = big_array[i];
			
			if(max < big_array[i]) {
				max = big_array[i];
				c = (char)(65+i);
			}
		}
		
		if(same == max)
			c = '?';
		
		System.out.println(c);
	}

}
