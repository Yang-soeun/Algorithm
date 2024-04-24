import java.util.*;

class Solution {
    static int N; //행
    static int M; //열
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        return bfs(maps);
    }
    
    public static class Pos{
        int x;
        int y;
        int count;
        
        public Pos(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public static int bfs(int[][] maps){
        int min = Integer.MAX_VALUE;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 0));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            
            if(poll.x == N-1 && poll.y == M-1){
                if(poll.count < min){
                    min = poll.count;
                }
            }
            
            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];
                
                if(newX <0 || newY <0 || newX >=N || newY >=M) continue;
                if(maps[newX][newY] != 0 && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY, poll.count + 1));
                }
            }
        }
        
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        
        return min + 1;
    }
}
