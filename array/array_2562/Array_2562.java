package array_2562;

import java.util.Scanner;

/*
 * 문제: 최댓값
 * 문제 설명: 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇번째 수인지를 구하는 프로그램을 작성
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
