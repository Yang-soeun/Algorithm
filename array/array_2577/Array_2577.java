package array_2577;

import java.util.Scanner;

/*
 * ����: ������ ����
 * ���� ����: �� ���� �ڿ��� A, B, C�� �־��� �� AxBxC�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷��� �ۼ�.
*/

public class Array_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int[] array = {0,0,0,0,0,0,0,0,0,0};//������ ������ ���� �迭
		int A, B, C;
		int number;
		
		
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		
		number = A*B*C;
		
		while(true){
			int i = 10;
			
			if((number%i) == 0)
				array[0] +=1;
			else if((number%i) == 1)
				array[1] +=1;
			else if((number%i) == 2)
				array[2] +=1;
			else if((number%i) == 3)
				array[3] +=1;
			else if((number%i) == 4)
				array[4] +=1;
			else if((number%i) == 5)
				array[5] +=1;
			else if((number%i) == 6)
				array[6] +=1;
			else if((number%i) == 7)
				array[7] +=1;
			else if((number%i) == 8)
				array[8] +=1;
			else if((number%i) == 9)
				array[9] +=1;
			
			number = (int)(number/10);
			if(number == 0) {
				break;
			}
		}
		
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
