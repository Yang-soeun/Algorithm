package math_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����: ����
 * ���� ����: ���������� �̷���� ������ �ִ�.
 * ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ְ� ������ ���� ������ ����
 * �� ���� ���� ������������ ����ϴ� ���α׷��� �ۼ�.
*/

public class Math_2292 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int pass = 0;//������ ���� ����
		int room = 1;//���� ����

		while(true) {
			room += pass*6;
			if(room >= n)
				break;
			pass++;
		}
		System.out.println(pass+1);
	}
}
