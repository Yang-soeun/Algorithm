package math_1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * ����: �Ҽ� ���ϱ�
 * ���� ����: M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ�.(�����佺�׳׽��� ü)
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
		prime[0] = prime[1] = true;//�Ҽ��� �ƴϸ� true
		
		for(int i =2; i<= Math.sqrt(b); i++) {
			if(prime[i] == true)//�̹� üũ �� �迭�̸� skip
				continue;
			for(int j = i*i; j<prime.length; j = j+i)//��� ����
				prime[j] = true;
		}
		
		for(int i = a; i<=b; i++) {
			if(prime[i] == false)
				bw.write(i + "\n");
		}
		
		bw.close();
	}
}
