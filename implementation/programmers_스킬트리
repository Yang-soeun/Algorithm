import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean possible = true;

        String[] order = skill.split("");

        for(int i = 0; i < skill_trees.length; i++){
            String skillTree = skill_trees[i];
            for(int j = 1; j<order.length; j++){
                if(!skillTree.contains(order[j-1]) && skillTree.contains(order[j])){
                    possible = false;
                    break;
                }
                if(skillTree.contains(order[j]) && skillTree.indexOf(order[j-1]) > skillTree.indexOf(order[j])){
                    possible = false;
                    break;
                }
            }
            if(possible){
                answer ++;
            }
            possible = true;
        }
        return answer;
    }
}
