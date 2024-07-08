import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int answer[] = new int[size];
        
        int i = 0;
        
        for (long k = left; k <= right; k++) {
            long r = k / n + 1;
            long c = k % n + 1;
            answer[i++] = Math.max((int)r, (int)c);
        }
        
        return answer;
    }
}
