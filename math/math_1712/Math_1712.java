package math_1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ����: ���ͺб���
 * ���� ����: ���ʷ� �� ������ �� ��뺸�� ������ ������ �߻��ϴ� ������ ���ͺб����̶�� �Ѵ�.
 * A, B, C�� �־�������, ���ͺб����� ���ϴ� ���α׷��� �ۼ�. 
*/

public class Math_1712 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(C <= B)
			System.out.println(-1);
		else 
			System.out.println((A/(C-B)) + 1);
		}
}
