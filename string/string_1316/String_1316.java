package string_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 그룹 단어 체커
 * 문제 설명: 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성.
*/

public class String_1316 {
	
	//그룹 단어인지 확인하는 함수
	public static boolean check_word(String str) {
		char c, h;

		for(int i = 0; i<str.length()-1; i++) {
			c = str.charAt(i);
			for(int j = i+1; j<str.length(); j++) {
				h = str.charAt(j);
				
				if(c == h) {
					if(i != j-1)
						return false;
					i=j;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String[] word = new String[n];
		
		for(int i =0; i<n; i++) {
			word[i] = br.readLine();
		}
		
		for(int i = 0; i<n; i++) {
			if(check_word(word[i]))
				count ++;
		}
		
		System.out.println(count);
	}
}
