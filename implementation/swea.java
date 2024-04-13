import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		int buy = 0;
		int max = Integer.MIN_VALUE;
		int gain = 0;
		int count = 0;
		int[] cost;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num =Integer.parseInt(br.readLine());
			cost = new int[num];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<num; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#" + test_case + " ");
			
			for(int j = cost.length -1; j>=0; j--) {
				if(cost[j] > max) {
					gain += max * count - buy;
					buy = 0;
					count =0;
					max = cost[j];
				}
				else {
					buy+=cost[j];
					count++;
				}
			}
			
			gain += max * count - buy;
			
			sb.append(gain + "\n");
			buy = 0;
			max = 0;
			count = 0;
			gain = 0;
		}
		
		System.out.print(sb);
	}
}
