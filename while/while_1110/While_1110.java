package while_1110;

import java.util.Scanner;

/*
 * ����: ���ϱ� ����Ŭ
 * ���� ����: N�� �־�������, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷� �ۼ�.
 */

public class While_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n;
		int newNum;
		int sum = 0, cycle = 0;
		
		n = in.nextInt();
		newNum = n;
		
		while(true) {
			if(newNum <10) {//10���� �������
				if(n == 0) {
					cycle = 1;
					break;
				}
				else {
					sum = newNum;
					newNum = (newNum%10)*10+sum;
					cycle++;
					
					if(newNum == n)//������ ����
						break;
				}
			}
			
			if(newNum >=10) {//10 �̻��� ���
				sum = newNum/10 + newNum%10;//�� �ڸ��� ���� ���Ѵ�.
				newNum = (newNum%10)*10 + sum%10;
				cycle ++;
				
				if(newNum == n)
					break;
			}
		}
		
		System.out.println(cycle);
	}

}
