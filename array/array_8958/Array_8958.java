package array_8958;

import java.util.Scanner;

/*
 * ����: OX ����
 * ���� ����: O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�.
 * ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�.
 * OX ������ ����� �־�������, ������ ���ϴ� ���α׷��� �ۼ�
*/

public class Array_8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String[] testcase = new String[n];
		
		for(int i =0; i<n; i++) {
			testcase[i] = in.next();
		}
		
		int j=0;
		int score, totalscore;
		
		while(j <n) {
			String str = testcase[j];
			int len = str.length();
			score =0; totalscore =0;
			
			for(int k = 0; k<len; k++) {
				if(str.startsWith("O")) {
					score++;
					totalscore += score;
					str = str.substring(1);
				}
				else {
					score =0;
					str = str.substring(1);
				}
			}
			
			j++;
			System.out.println(totalscore);
		}
	}
}
