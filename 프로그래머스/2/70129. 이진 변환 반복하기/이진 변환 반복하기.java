import java.util.*;
import java.math.BigInteger;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
    
        int count = 0;
        BigInteger num = new BigInteger(s, 2); // 이진 문자열을 BigInteger로 변환
        int oneCount = num.bitCount();
        int zeroCount = s.length() - oneCount;
        
        answer[1] += zeroCount;
        
        while (num.compareTo(BigInteger.ONE) > 0) { // num이 1보다 큰 동안 반복
            count++;
            num = BigInteger.valueOf(oneCount); // 1의 개수를 새로운 BigInteger로 설정
            oneCount = num.bitCount();
            zeroCount = num.bitLength() - oneCount;
            answer[1] += zeroCount;
        }
        
        answer[0] = count;
        return answer;
    }
}