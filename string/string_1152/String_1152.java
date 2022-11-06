package string_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 단어의 개수
 * 문제 설명: 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
 * 이 문자열에 몇 개의 단어가 있는지 구하는 프로그램을 작성.
 * 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야한다.
*/

public class String_1152 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int i = 0;
		
		st = new StringTokenizer(br.readLine());
		
		while(true) {
			try {
				String str = st.nextToken();
				i++;
			}catch(Exception e) {
				break;
			}
		}
		
		System.out.println(i);
	}

}
