package math_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ����: ����Ʈ�� ����
 * ���� ����: ����Ʈ�� ������ ������ �ڿ��� n�� ���Ͽ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ��� �ϳ� �����Ѵٴ� ������ ��� �ִ�.
 * �ڿ��� n�� �־����� ��, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ���ϴ� ���α׷��� �ۼ�.
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
			prime[0] = prime[1] = true;//�Ҽ��� �ƴϸ� true
			for(int i =2; i<= Math.sqrt(2*n); i++) {
				if(prime[i] == true)//�̹� üũ �� �迭�̸� skip
					continue;
				for(int j = i*i; j<prime.length; j = j+i)//��� ����
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
