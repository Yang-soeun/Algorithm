package string_2675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제: 문자열 반복
 * 문제 설명: 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성.
*/

public class String_2675 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());//테스트 케이스 개수
		
		for(int i = 0; i< T; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());//반복 횟수
			String str = st.nextToken();//문자열 S
			
			for(int j = 0; j<str.length(); j++) {
				for(int k = 0; k<r; k++) {
					bw.write(str.charAt(j));//새로운 문자열 P
				}
			}
			
			bw.write("\n");
		}
		
		bw.close();
	}

}
