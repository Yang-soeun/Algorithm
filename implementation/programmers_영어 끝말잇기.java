import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i = 1; i< words.length; i++){
            String before = words[i-1];
            int len = before.length();
            String now = words[i];
            if(set.add(words[i]) && before.charAt(len-1) == now.charAt(0)){
                set.add(words[i]);
                continue;
            }

            answer[0] = (i%n) + 1;
            answer[1] = (i/n) + 1;
            break;
        }
        
        return answer;
    }
}
