package string_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ����: �ܾ��� ����
 * ���� ����: ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����.
 * �� ���ڿ��� �� ���� �ܾ �ִ��� ���ϴ� ���α׷��� �ۼ�.
 * ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ������Ѵ�.
*/

public class String_1152 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int i = 0;
		
		st = new StringTokenizer(br.readLine());
		
		while(true) {
			try {
				String str = st.nextToken();
				i++;
			}catch(Exception e) {
				break;
			}
		}
		
		System.out.println(i);
	}

}
