import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 평범한 배낭2
 */
public class Baekjoon_12920 {
    public static class Bag{
        int w;
        int v;

        public Bag(int w, int v){
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    // 물건의 종류
        int m = Integer.parseInt(st.nextToken());    // 가방의 최대 무게

        ArrayList<Bag> bags = new ArrayList<>();
        bags.add(new Bag(0,0));

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());


            int count = 1;
            while(count <= k) {
                bags.add(new Bag(v * count, c * count));
                k -= count;
                count *= 2;
            }
            if(k > 0) {
                bags.add(new Bag(v * k, c * k));
            }
        }

        int[][] dp = new int[bags.size() + 1][m+1];

        for(int i = 1; i<bags.size(); i++){
            for(int j = 1; j<=m; j++){
                if(bags.get(i).w > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bags.get(i).w] + bags.get(i).v);
                }
            }
        }

        System.out.println(dp[bags.size()-1][m]);
    }
}
