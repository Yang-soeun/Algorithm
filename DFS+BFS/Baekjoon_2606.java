/*
* 문제: 바이러스
* 첫째 줄에는 컴퓨터의 수가 주어진다.
* 컴퓨터의 수는 100이하이고, 각 컴퓨터에는 1번부터 차례대로 번호가 매겨진다.
* 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
* 그 수만큼 한줄에 한쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2606 {

    static int a, b;
    static int node[][];//그래프 배열
    static boolean visited[];//방문한 배열

    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;// 감염된 컴퓨터의 개수

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i = 1; i<=a; i++){
                if(node[x][i] == 1 && visited[i] == false)
                {
                    queue.offer(i);
                    visited[i] = true;
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = Integer.parseInt(br.readLine());//컴퓨터의 수
        b = Integer.parseInt(br.readLine());//연결되어 있는 컴퓨터 쌍의 수

        node = new int[a+1][a+1];
        visited = new boolean[a+1];

        for(int k = 1; k<=b; k++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            node[s][j] = node[j][s] =1;
        }

        System.out.println(bfs(1));

    }
}
