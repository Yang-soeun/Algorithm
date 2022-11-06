package string_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����: �ܾ� ����
 * ���� ����: ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ�.
 * ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
*/

public class String_1157 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] big_array = new int[26];
		int[] small_array = new int[26];
		
		String str = br.readLine();
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) < 97) {//�빮���� ���
				int index = str.charAt(i) - 65;
				big_array[index] +=1;
			}
			else {//�ҹ����� ���
				int index = str.charAt(i) - 97;
				small_array[index] +=1;
			}
		}
		
		//�� �迭 ��ġ��
		for(int i = 0; i< big_array.length; i++) {
			big_array[i] += small_array[i];
		}
		
		//�� ���� ���� ���ĺ� ���ϱ�
		int max = -1;
		int same = 0;
		char c = ' ';
		
		for(int i = 0; i<big_array.length; i++) {
			if(max == big_array[i])
				same = big_array[i];
			
			if(max < big_array[i]) {
				max = big_array[i];
				c = (char)(65+i);
			}
		}
		
		if(same == max)
			c = '?';
		
		System.out.println(c);
	}

}
