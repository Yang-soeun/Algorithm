package if_2480;

import java.util.Scanner;

/*
 * ����: �ֻ��� ����
 * ���� ����: 3���� �ֻ����� ���� ���� �־��� ��, ����� ����ϴ� ���α׷� �ۼ�.
*/

public class If_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int a, b, c;//3���� ���� ������ ����.
		int reward = 0;//����� ������ ����
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		
		if(a!=b && b!=c && a!=c) {//��� �ٸ� ���
			int max = Math.max(a, Math.max(b, c));//3���� �� �� ���� ū �� ����
			reward = max*100;
		}
		else if(a == b && b == c && c == a)//��� ���� ���
			reward = 10000 + (a*1000);
		else if(a==b || a==c || b==c) {//�ΰ��� ���� ���
			int same = a;
			
			if(a == b) 
				same = a;
			else if(b == c)
				same = b;
			
			reward = 1000 + (same*100);
		}
		System.out.println(reward);
	}

}
