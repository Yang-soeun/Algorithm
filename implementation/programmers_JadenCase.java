class Solution {
    public String solution(String s) {
        boolean last = false;
        String[] str = s.split(" ");
        String answer = "";
        
        if(s.charAt(s.length()-1) == ' '){
            last = true;
        }
        
        int i;
        for(i = 0; i<str.length; i++){
            if(str[i].length() == 0){
                answer += " ";
                continue;
            }
            
            char before = str[i].charAt(0);
            String sub = str[i].substring(1);
            String lower = sub.toLowerCase();
            
            if(before <= 57){
                answer += before + lower + " ";
                continue;
            }
            
            char upper = Character.toUpperCase(before);
            answer += upper + lower + " ";
        }

        if(last){
            return answer.trim() + " ";
        }
        return answer.trim();

    }
}
