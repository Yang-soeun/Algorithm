package string_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����: �׷� �ܾ� üĿ
 * ���� ����: �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�.
 * �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ�.
*/

public class String_1316 {
	
	//�׷� �ܾ����� Ȯ���ϴ� �Լ�
	public static boolean check_word(String str) {
		char c, h;

		for(int i = 0; i<str.length()-1; i++) {
			c = str.charAt(i);
			for(int j = i+1; j<str.length(); j++) {
				h = str.charAt(j);
				
				if(c == h) {
					if(i != j-1)
						return false;
					i=j;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String[] word = new String[n];
		
		for(int i =0; i<n; i++) {
			word[i] = br.readLine();
		}
		
		for(int i = 0; i<n; i++) {
			if(check_word(word[i]))
				count ++;
		}
		
		System.out.println(count);
	}
}
