package string_2908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * ����: ���
 * ���� ����: ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�.
 * �� ���� ���� ���� ���ڸ� ���̿�, 0�� ���ԵǾ� ���� �ʴ�.
 * �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ�.
*/

public class String_2908 {
	
	//���ڸ� �Ųٷ� ����� �Լ�
	public static int newNum(int n) {
		int newNum;
		
		newNum = (n%10)*100 + ((n%100)/10)*10 + n/100;
		
		return newNum;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int newA = newNum(a);
		int newB = newNum(b);
		
		if(newA > newB)
			System.out.println(newA);
		else
			System.out.println(newB);
			
	}

}
