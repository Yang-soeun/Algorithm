import java.math.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int aPos = a/2 + a%2;
        int bPos = b/2 + b%2;        
        
        while(aPos != bPos){
            answer++;
            aPos = aPos/2 + aPos%2;
            bPos = bPos/2 + bPos%2;
        }
        
        return answer;
    }
}
