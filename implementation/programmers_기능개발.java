import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();    
        int count = 0;
        int done = 0;

        for(int i = 0; i< progresses.length; i++){
            if((progresses[i] + count*speeds[i]) >= 100){
                done++;
                continue;
            }
            while(true){
                if(done != 0){
                    list.add(done);
                    done = 0;
                }
                count++;
                if((progresses[i] + count*speeds[i] >= 100)){
                    done++;
                    break;
                } 
            }
        }
        
        list.add(done);
        int[] answer = new int[list.size()];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
