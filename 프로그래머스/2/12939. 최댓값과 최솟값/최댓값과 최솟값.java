import java.util.*;

class Solution {
    public String solution(String s) {
        
        int[] number = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int max  = Arrays.stream(number).max().getAsInt();
        int min  = Arrays.stream(number).min().getAsInt();
        
        return min + " " + max;
    }
}