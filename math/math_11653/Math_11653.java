package math_11653;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 문제: 소인수분해
 * 문제설명: 정수 N이 주어졌을 떄, 소인수분해하는 프로그램을 작성.
*/

public class Math_11653 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = in.nextInt();
		
		for(int i = 2; i<= Math.sqrt(n); i++) {
			while(n%i == 0) {
				bw.write(i + "\n");
				n/=i;
			}
		}
		if(n!=1)//소수인 경우
			bw.write(n+"\n");
		
		bw.close();
	}

}
