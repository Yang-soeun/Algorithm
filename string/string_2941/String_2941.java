package string_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: 크로아티아 알파벳
 * 문제 설명: 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력하는 프로그램을 작성.
*/

public class String_2941 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int a = 0;
		int b = 0;
		int count = 0;
		int word_len = str.length();
		
		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		int i = 0;
		while(true) {
			if(str.contains(cro[i])) {
				if(i==2)
					b +=3;
				else
					a +=2;
				count ++;
				str = str.replaceFirst(cro[i], " ");
				i = 0;
			}
			else
				i++;
			
			if(i == cro.length)
				break;
		}
		
		count += (word_len-(a+b));
		System.out.println(count);
	}

}
