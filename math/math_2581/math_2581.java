package math_2581;

import java.util.Scanner;

/*
 * ����: �Ҽ�
 * ���� ����: �ڿ��� M�� N�� �־��� �� M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ��� 
 * �̵� �Ҽ��� �հ� �ּڰ��� ã�� ���α׷��� �ۼ�.
*/

public class math_2581 {

	public static boolean check(int a) {//�Ҽ��� �Ǻ��ϴ� �Լ�
		if(a == 0 || a == 1)
			return false;
		
		for(int i =2; i<a; i++) {
			if(a % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int count = 0;
		int sum = 0;
		int min = 0;
		
		while(a<=b) {
			if(check(a) == true) {
				if(count == 0)
					min = a;
				sum+=a;
				count ++;
			}
			a++;
		}
		
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
