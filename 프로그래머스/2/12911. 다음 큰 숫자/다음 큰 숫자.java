import java.util.*;

class Solution {
    public int solution(int n) {
        int one = Integer.bitCount(n);
        int next = n + 1;
        
        while(true){
            if(Integer.bitCount(next) == one){
                break;
            } else{
                next++;
            }
        }
        
        return next;
    }
}