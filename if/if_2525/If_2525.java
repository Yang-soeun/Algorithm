package if_2525;

import java.util.Scanner;

/*
 * ������: ���� �ð�
 * ���� ����: ���� �������̸� �����ϴ� �ð��� ���챸�̸� �ϴ� �� �ʿ��� �ð��� �д����� �־����� ��,
 * ���챸�̰� ������ �ð��� ����ϴ� ���α׷��� �ۼ�.
 */

public class If_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int a, b, c;
		
		a = in.nextInt();//��
		b = in.nextInt();//��
		c = in.nextInt();//�丮�ϴµ� �ʿ��� �ð�
		
		b = b+c;
		
		while(true) {
			if(b>59) {
				a++;
				b = b-60;
			}
			else if(a>23)
				a = a-24;
			else
				break;
		}
		
		System.out.println(a + " " + b);
		
	}
}
