import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int sum = 0;
        
        for(int i = 0; i<arr2[0].length; i++){
            for(int j = 0; j<arr1.length; j++){
                for(int k = 0; k<arr1[0].length; k++){
                    sum += arr1[j][k] * arr2[k][i];
                }
                answer[j][i] = sum;
                sum = 0;
            }
        }

        return answer;
    }
}