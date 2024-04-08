package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리
 */
public class Baekjoon_1068 {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 0; i<=N; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            int node = Integer.parseInt(st.nextToken());
            tree.get(node + 1).add(i);
        }

        int deletePos = Integer.parseInt(br.readLine());
        deleteNode(deletePos + 1);

        System.out.println(countLeafNode());
    }

    public static void deleteNode(int deletePos){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(deletePos);
        visited[deletePos] = true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            List<Integer> childs = tree.get(poll);
            for (Integer child : childs) {
                visited[child] = true;
                queue.add(child);
            }
            tree.get(poll).clear();
        }
    }

    public static int countLeafNode(){
        int count = 0;

        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                if(tree.get(i).isEmpty()){
                    count++;
                    continue;
                }
                if(tree.get(i).size() ==1 && visited[tree.get(i).get(0)]){
                    count++;
                }
            }
        }

        return count;
    }
}
