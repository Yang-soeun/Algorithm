package function_1065;

import java.util.Scanner;

/*
 * ����: �Ѽ�
 * ���� ����: 
 * � ���� ���� X�� �� �ڸ��� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�.
 * ���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�.
 * N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ�.
*/

public class Function_1065 {

	public static int han(int n) {
		int hnum = 99;
		int a, b, c;
		
		for(int i =111; i<= n; i++) {
			int z =i;
			
			a = z/100;
			z %= 100;
			b = z/10;
			c = z%10;
			
			if((b-a) == (c-b))
				hnum ++;
		}
		
		return hnum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);//BufferedReader�� �ϸ� �� ������
		
		int num = in.nextInt();
		
		if(num < 100)
			System.out.println(num);
		else {
			System.out.println(han(num));
		}
	}
}
