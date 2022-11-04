package math_2775;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * ����: �γ�ȸ���� ���׾�
 * ���� ����: ����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� ��� ������ ��Ű�� �Դٰ� ������ ��,
 * �־��� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ִ��� ����ϴ� ���α׷��� �ۼ�.
 * ��, ����Ʈ���� 0������ �ְ� �� ������ 1ȣ���� ������, 0���� iȣ���� i���� ���.
*/

public class Math_2775 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = in.nextInt();//Test case�� ��
		
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
