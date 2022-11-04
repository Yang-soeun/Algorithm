package math_1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제: 소수 구하기
 * 문제 설명: M이상 N이하의 소수를 모두 출력하는 프로그램을 작성.(에라토스테네스의 체)
 */

public class Math_1929 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		boolean prime[] = new boolean[b+1];
		prime[0] = prime[1] = true;//소수가 아니면 true
		
		for(int i =2; i<= Math.sqrt(b); i++) {
			if(prime[i] == true)//이미 체크 한 배열이면 skip
				continue;
			for(int j = i*i; j<prime.length; j = j+i)//배수 제거
				prime[j] = true;
		}
		
		for(int i = a; i<=b; i++) {
			if(prime[i] == false)
				bw.write(i + "\n");
		}
		
		bw.close();
	}
}
