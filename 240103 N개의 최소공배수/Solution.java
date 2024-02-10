class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        int remainder = max % min;
        
        if (remainder == 0) {
            return min;
        }
        
        return gcd(min, remainder);
    }
}