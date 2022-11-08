package while_10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class While_10951 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//String str;
		
		//(str = br.readLine()) != null 이렇게 적어도 정답이 되지만 여기서는 오류가 남
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());
				//int a = Integer.parseInt(st.nextToken());
				//int b = Integer.parseInt(st.nextToken());
				
				sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
				
			}catch(Exception e) {//예외가 발생하면 while문 종료
				break;
			}
		}
		
		System.out.print(sb);
	}

}
