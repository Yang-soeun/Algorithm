package string_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����: ������ ��
 * ���� ����: N���� ���ڰ� ���� ���� �����ִ�. �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ�.
*/

public class String_11720 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum =0;
		
		for(int i = 0; i< n; i++) {
			char c = str.charAt(i);
			sum += Character.getNumericValue(c);
		}
		
		System.out.println(sum);
	}

}
