package math_10250;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * ����: ACM ȣ��
 * ���� ����: �ʱ⿡ ��� ���� ����ִٰ� �����Ͽ� ��å�� ���� N��°�� ������ �մԿ��� ������ �� ��ȣ�� ����ϴ� ���α׷��� �ۼ�.
 * ù ��° �մ��� 101 ȣ, �� ��° �մ��� 201ȣ ��� ���� �����Ѵ�.
*/

public class Math_10250 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int col = 0, row = 0;
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
		
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			row = (n/h) + 1;
			col = n%h;
			if(col == 0) {
				row = n/h;
				col = h;
			}
			
			bw.write((col*100) + row + "\n");
		}
		//bw.flush();
		bw.close();
	}

}
