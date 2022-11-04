package math_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 베르트랑 공존
 * 문제 설명: 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성.
*/

public class Math_4948 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int count =0;
		
		while(n != 0) {
			boolean prime[] = new boolean[2*n+1];
			prime[0] = prime[1] = true;//소수가 아니면 true
			for(int i =2; i<= Math.sqrt(2*n); i++) {
				if(prime[i] == true)//이미 체크 한 배열이면 skip
					continue;
				for(int j = i*i; j<prime.length; j = j+i)//배수 제거
					prime[j] = true;
				}
			
			for(int i = n+1; i<=2*n; i++) {
				if(prime[i] == false)
					count++;
			}
			
			sb.append(count).append("\n");
			count =0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
		}
		
		System.out.println(sb);
	}
}
