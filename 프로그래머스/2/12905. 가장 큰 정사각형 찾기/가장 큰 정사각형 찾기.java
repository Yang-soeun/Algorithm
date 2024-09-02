class Solution
{
    public int solution(int [][]board)
    {
        int max = 0;
        
        int[][] array = new int[board.length+1][board[0].length+1];
        
    
        for (int i = 1; i <= board.length; i++) {        
            for (int j = 1; j <= board[0].length; j++) {            
                array[i][j] = board[i-1][j-1];        
            }    
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {   
                if (array[i][j] == 1) {
                    array[i][j] = Math.min(array[i - 1][j], Math.min(array[i][j - 1], array[i - 1][j - 1])) + 1;                                 
                    max = Math.max(array[i][j], max);                          
                }
            }
        }
    

        return max*max;
    }
}