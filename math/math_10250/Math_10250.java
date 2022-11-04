package math_10250;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제: ACM 호텔
 * 문제 설명: 초기에 모든 방이 비어있다고 가정하에 정책에 따라 N번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램을 작성.
 * 첫 번째 손님은 101 호, 두 번째 손님은 201호 등과 같이 배정한다.
*/

public class Math_10250 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int col = 0, row = 0;
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
		
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			row = (n/h) + 1;
			col = n%h;
			if(col == 0) {
				row = n/h;
				col = h;
			}
			
			bw.write((col*100) + row + "\n");
		}
		//bw.flush();
		bw.close();
	}

}
