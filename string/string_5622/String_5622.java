

package string_5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����: ���̾�
 * ���� ����: ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ�.
*/

public class String_5622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sec =0;
		
		for(int i = 0; i<str.length(); i++) {
			int d = str.charAt(i);
			if(d-65 <=2)
				sec+=3;
			else if(d-65 <=5)
				sec +=4;
			else if(d-65 <=8)
				sec +=5;
			else if(d-65<=11)
				sec +=6;
			else if(d-65 <=14)
				sec +=7;
			else if(d-65 <=18)
				sec +=8;
			else if(d-65 <=21)
				sec +=9;
			else if(d-65 <=25)
				sec +=10;
		}
		System.out.println(sec);
	}
}



