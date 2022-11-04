package math_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 달팽이는 올라가고 싶다.
 * 문제 설명: 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성.
*/

public class Math_2869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());//낮에 올라갈 수 있는 미터
		int B = Integer.parseInt(st.nextToken());//밤에 자는 동안 미끄러지는 미터
		int V = Integer.parseInt(st.nextToken());//정상 높이
		int day = 0;
		
		day = (V-B)/(A-B);
		if((V-B)%(A-B) !=0)
			day++;
		System.out.println(day);
	}
}
