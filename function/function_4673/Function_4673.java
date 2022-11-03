package function_4673;

/*
 * ����: ���� �ѹ�
 * ���� ����: 
 * �����ڰ� ���� ���ڸ� ���� �ѹ���� �Ѵ�.
 * 10000 ���� �۰ų� ���� ���� �ѹ��� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ�.
*/
public class Function_4673 {

	//�־��� ���� ���� ���� ����ϴ� �Լ�
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
		 boolean[] array = new boolean[10001];//10000������ ����.
		 
		 for(int i =1; i<=10000; i++) {
			 int n = d(i);
			 
			 if(n <= 10000)
				 array[n] = true;//�����ѹ��� �ƴϴ�.
			 if(array[i]!=true)
				 System.out.println(i);
		 }
	}
}
