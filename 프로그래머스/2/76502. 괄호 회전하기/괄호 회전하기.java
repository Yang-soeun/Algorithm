import java.util.*;

class Solution {
    static int len;
    static String str;
    
    public int solution(String s) {
        int answer = 0;
        str = s;
        len = s.length();
        
        if(isCollect(s)){
            answer++;
        }
        for(int i = 0; i<len-1; i++){
            str = str.substring(1) + str.charAt(0);
            if(isCollect(str)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isCollect(String str){
        Stack<Character> stack = new Stack<>();
    
        for(int i = 0; i<len; i++){
            char c = str.charAt(i);
            
            if(stack.isEmpty()){
                stack.push(c);
            } else if(c == ')' && stack.peek() == '('){
                stack.pop();
            } else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            } else if(c == ']' && stack.peek() == '['){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}