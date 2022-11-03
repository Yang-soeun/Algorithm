package function_4673;

/*
 * 문제: 셀프 넘버
 * 문제 설명: 
 * 생성자가 없는 숫자를 셀프 넘버라고 한다.
 * 10000 보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성.
*/
public class Function_4673 {

	//주어진 수의 다음 수를 계산하는 함수
	public static int d (int number) {
		int sum = number;
		
		for(int i = 10000; i>=1; i/=10) {
			int quo = number/i;
			
			if(quo !=0) {
				number %=i;
				sum += quo;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean[] array = new boolean[10001];//10000이하의 숫자.
		 
		 for(int i =1; i<=10000; i++) {
			 int n = d(i);
			 
			 if(n <= 10000)
				 array[n] = true;//셀프넘버가 아니다.
			 if(array[i]!=true)
				 System.out.println(i);
		 }
	}
}
