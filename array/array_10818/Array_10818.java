package array_10818;

import java.util.Scanner;

/*
 * 문제: 최소, 최대
 * 문제 설명: N개의 정수가 주어진다. 이때 최소값과 최댓값을 구하는 프로그램을 작성.
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
