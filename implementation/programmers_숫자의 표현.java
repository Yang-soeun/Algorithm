class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += j;
                if(sum > n) break;
                if(sum == n){
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}

//숫자의 연속된 자연수의 합은 주어진 숫자의 홀수의 약수 개수와 같다 - 정수론
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i<=n; i+=2){
            if(n%i == 0){
                answer++;
            }
        }
        
        return answer;
    }
}
