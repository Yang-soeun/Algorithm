package math_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ����: �����̴� �ö󰡰� �ʹ�.
 * ���� ����: �����̰� ���� ���븦 ��� �ö󰡷���, ��ĥ�� �ɸ����� ���ϴ� ���α׷��� �ۼ�.
*/

public class Math_2869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());//���� �ö� �� �ִ� ����
		int B = Integer.parseInt(st.nextToken());//�㿡 �ڴ� ���� �̲������� ����
		int V = Integer.parseInt(st.nextToken());//���� ����
		int day = 0;
		
		day = (V-B)/(A-B);
		if((V-B)%(A-B) !=0)
			day++;
		System.out.println(day);
	}
}
