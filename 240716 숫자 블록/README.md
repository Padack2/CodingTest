class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = findDivisor(i);
        }
        return answer;
    }
    
    int findDivisor(long n) {
        if (n < 2) {
            return 0;
        }
        
        int max = 1;
        
        for(int i = 2; i <= Math.sqrt(n); i++){   
            if(n % i == 0){
                if(n / i > 10_000_000){
                    max = i;
                    continue;
                }
                return (int) (n / i);
            }
        } 
        
        return max;
    }
}