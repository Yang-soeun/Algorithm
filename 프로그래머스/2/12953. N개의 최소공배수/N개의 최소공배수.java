import java.util.*;

class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        
        int g = gcd(arr[0], arr[1]);
        int answer = lcm(arr[0], arr[1], g);
        
        for(int i = 2; i<arr.length; i++){
            answer = lcm(answer, arr[i], gcd(answer, arr[i]));
        }
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    
    public int lcm(int a, int b, int gcd){
        return (a*b)/gcd;
    }
}