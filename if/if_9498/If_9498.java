package if_9498;

import java.util.Scanner;
/*
 * ����: ���� ����
 * ���� ����: ���� ������ �Է¹޾� 90~100���� A, 80~89���� B, 70~79���� C, 60~60���� D, �������� F�� ����ϴ� ���α׷�.
*/
public class If_9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		int score = in.nextInt();
		
		if(90 <= score && score <= 100)
			System.out.println("A");
		else if (80 <= score && score <= 89)
			System.out.println("B");
		else if(70 <= score && score <= 79)
			System.out.println("C");
		else if(60 <= score && score <= 69)
			System.out.println("D");
		else
			System.out.println("F");
	}
}
