import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        Map<String, Integer> origin = new HashMap<>();
        
        for(int i = 0; i<want.length; i++){
            origin.put(want[i], number[i]);
        }
        
        for(int i = 0; i<discount.length-9; i++){
            Map<String, Integer> find = new HashMap<>();
            for(int j = i; j<i+10; j++){
                find.put(discount[j], find.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isPossible = true;
            
            for(String key : origin.keySet()){
                if(origin.get(key) != find.get(key)){
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible){
                result++;
            }
        }
        
        return result;
    }
}