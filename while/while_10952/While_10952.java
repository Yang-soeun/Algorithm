package while_10952;

import java.util.Scanner;

/*
 * ����: A+B-5
 * ���� ����: �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ�.
*/

public class While_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
	
		int a, b;
	
		a = in.nextInt();
		b = in.nextInt();
		
		while(a!=0 || b!=0) {
			System.out.println(a+b);		
			a = in.nextInt();
			b = in.nextInt();
		}
	}
}