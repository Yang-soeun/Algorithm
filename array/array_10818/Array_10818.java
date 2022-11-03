package array_10818;

import java.util.Scanner;

/*
 * ����: �ּ�, �ִ�
 * ���� ����: N���� ������ �־�����. �̶� �ּҰ��� �ִ��� ���ϴ� ���α׷��� �ۼ�.
 */

public class Array_10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] array = new int[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = in.nextInt();
		}
		
		int min = array[0];
		int max = array[0];
		
		for(int i = 0; i<n; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}
		
		System.out.println(min + " " + max);
	}
}
