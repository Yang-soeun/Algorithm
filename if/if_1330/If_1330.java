package if_1330;

import java.util.Scanner;

/*
 * ����: �� �� ���ϱ�
 * ���� ����: �� ���� A�� B�� �־����� ��, A�� B�� ���ϴ� ���α׷�
 */
public class If_1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		if(a > b)
			System.out.println(">");
		else if (a < b)
			System.out.println("<");
		else if (a == b)
			System.out.println("==");
	}
}
