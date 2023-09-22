class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1; 
        int max = 200000000;
	      
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (checkStone(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean checkStone(int[] stones, int k, int friends) {
      	int skip = 0;
        
        for (int stone : stones) {
            if (stone - friends < 0)
                skip++;
            else
                skip = 0;
            
            if (skip == k)
                return false;
        }
        
        return true;
    }
}