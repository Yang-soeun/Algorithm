class Solution {
    public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];	
		
		int area = brown + yellow;
		int width = 0;
		
		//최소한 세로의 길이는 3이상
		for(int length = 3; length<=area; length++) {
			if(area % length ==0)
				width = area / length;
			if(yellow == (length-2) * ((width) -2)) {
				answer[0] = width;
				answer[1] = length;
				break;
			}
			
		}
		return answer;
    }
}