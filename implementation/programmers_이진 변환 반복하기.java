import java.util.*;
import java.math.BigInteger;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
    
        int count = 0;
        BigInteger num = new BigInteger(s, 2);
        int oneCount = num.bitCount();
        int zeroCount = s.length() - oneCount;
        
        answer[1] += zeroCount;
        
        while (num.compareTo(BigInteger.ONE) > 0) {
            count++;
            num = BigInteger.valueOf(oneCount);
            oneCount = num.bitCount();
            zeroCount = num.bitLength() - oneCount;
            answer[1] += zeroCount;
        }
        
        answer[0] = count;
        return answer;
    }
}
