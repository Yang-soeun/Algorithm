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
		
		//(str = br.readLine()) != null �̷��� ��� ������ ������ ���⼭�� ������ ��
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());
				//int a = Integer.parseInt(st.nextToken());
				//int b = Integer.parseInt(st.nextToken());
				
				sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
				
			}catch(Exception e) {//���ܰ� �߻��ϸ� while�� ����
				break;
			}
		}
		
		System.out.print(sb);
	}

}
