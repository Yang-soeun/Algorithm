import java.util.*;

class Solution {
    static boolean[][] visited;

    public static void network(int h, int[][] array, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(h);
        
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            
            for(int i = 0; i<n; i++){
                if(!visited[poll][i] && array[poll][i] == 1){
                    visited[poll][i] = true;
                    queue.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visited[i][j] == false && computers[i][j] == 1){
                    visited[i][j] = true;
                    network(j, computers, n);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
