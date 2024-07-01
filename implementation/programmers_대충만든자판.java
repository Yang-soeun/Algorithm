import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
           
        for(int i = 0; i<targets.length; i++){
            int total = 0;     
            String str = targets[i];
            char[] chars = str.toCharArray();
            
            for(int j = 0; j<chars.length; j++){
                int min = Integer.MAX_VALUE;
                char c = chars[j];
                for(int k = 0; k<keymap.length; k++){
                    if(keymap[k].indexOf(c) != -1){
                        min = Math.min(min, keymap[k].indexOf(c) + 1);
                    }
                }
                if(min == Integer.MAX_VALUE){   //못 찾은 경우
                    total = -1; //-1로 하고
                    break; //이 문자열은 더이상 검사 안함
                }
                total+=min;
            }
            answer[i] = total;
        }
        
        return answer;
    }
}
