package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 */
public class Baekjoon_11725 {
    static int[] parents;
    static int N;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        tree = new ArrayList<>();

        for (int i = 0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        find();

        for(int i = 1; i<N; i++){
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }
    public static void find(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parents[0] = 1;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for (Integer i : tree.get(poll)) {
                if(parents[i-1] == 0){
                    parents[i-1] = poll;
                    queue.add(i);
                }
            }
        }
    }
}
