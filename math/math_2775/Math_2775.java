package math_2775;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 문제: 부녀회장이 될테야
 * 문제 설명: 아파트에 비어있는 집은 없고 모든 거주민들이 계약 조건을 지키고 왔다고 가정할 때,
 * 주어진 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하는 프로그램을 작성.
 * 단, 아파트에는 0층부터 있고 각 층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
*/

public class Math_2775 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = in.nextInt();//Test case의 수
		
		for(int i = 0; i<T; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			int[] array = new int[n];
			int count =1;
			
			if(k == 0)
				bw.write(n);
			
			else {
				for(int j = 0; j<n; j++) {
					array[j] += count;
					count ++;
				}
				
				for(int h = 0; h<k;h++) {
					for(int z = 0; z<n; z++) {
						if(z !=0)
							array[z] = array[z] + array[z-1];
					}
				}
				bw.write(array[n-1] + "\n");
			}
		}
		bw.close();
	}
}
