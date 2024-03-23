class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);

        for (String num : str.split("0")) {
            if (!num.equals("") && isPrime( Long.parseLong(num))) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}