package string_10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ����: ���ĺ� ã��
 * ���� ����: ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����.
 * ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� �ʴ� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ�.
*/

public class String_10809 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] location = new int[26];
		
		for(int i = 0; i<location.length; i++)
			location[i] = -1;//-1�� �ʱ�ȭ
		
		for(int i = 0; i<str.length(); i++ ) {
			char c = str.charAt(i);
			int index = c;
			
			index = index -97;
			if(location[index] == -1) 
				location[index] = i;
		}
		
		for(int j : location)
			bw.write(j + " ");
		
		bw.close();
	}
}
