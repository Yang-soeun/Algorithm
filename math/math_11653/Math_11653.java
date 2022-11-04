package math_11653;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * ����: ���μ�����
 * ��������: ���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ�.
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
		if(n!=1)//�Ҽ��� ���
			bw.write(n+"\n");
		
		bw.close();
	}

}
