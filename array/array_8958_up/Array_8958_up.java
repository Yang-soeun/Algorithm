package array_8958_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//OX 퀴즈 문제 더 좋은 성능

public class Array_8958_up {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i =0; i<test_case; i++) {
			int score = 0;
			int total_score =0;
			
			for(byte value : br.readLine().getBytes()) {
				if(value == 'O') {
					score++;
					total_score +=score;
				}
				else
					score=0;
			}
			sb.append(total_score).append("\n");
		}
		System.out.println(sb);
	}
}
