package array_2562;

import java.util.Scanner;

/*
 * ����: �ִ�
 * ���� ����: 9���� ���� �ٸ� �ڿ����� �־��� ��, �̵� �� �ִ��� ã�� �� �ִ��� ���° �������� ���ϴ� ���α׷��� �ۼ�
*/

public class Array_2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[9];
		
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++) {
			array[i] = in.nextInt();
		}
		
		int max = array[0];
		int maxindex = 1;
		
		for(int i = 0; i< array.length; i++) {
			if(max < array[i]) {
				max = array[i];
				maxindex = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(maxindex);
	}
}
