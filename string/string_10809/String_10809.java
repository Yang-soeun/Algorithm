package string_10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 문제: 알파벳 찾기
 * 문제 설명: 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않는 경우에는 -1을 출력하는 프로그램을 작성.
*/

public class String_10809 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] location = new int[26];
		
		for(int i = 0; i<location.length; i++)
			location[i] = -1;//-1로 초기화
		
		for(int i = 0; i<str.length(); i++ ) {
			char c = str.charAt(i);
			int index = c;
			
			index = index -97;
			if(location[index] == -1) 
				location[index] = i;
		}
		
		for(int j : location)
			bw.write(j + " ");
		
		bw.close();
	}
}
