package math_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 벌집
 * 문제 설명: 육각형으로 이루어진 벌집이 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최고 개수의 방을 지나서 갈때
 * 몇 개의 방을 지나가는지를 계산하는 프로그램을 작성.
*/

public class Math_2292 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int pass = 0;//지나는 방의 개수
		int room = 1;//방의 개수

		while(true) {
			room += pass*6;
			if(room >= n)
				break;
			pass++;
		}
		System.out.println(pass+1);
	}
}
