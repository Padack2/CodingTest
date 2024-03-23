class Solution {
    
    public boolean divisible(int[] arr, int num) {
        for (int n : arr) {
            if (n % num != 0) return false;
        }

        return true;
    }
    
    public boolean indivisible(int[] arr, int num) {
        for (int n : arr) {
            if (n % num == 0) return false;
        }
        
        return true;
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        for (int i = 2; i <= Math.max(arrayA[0], arrayB[0]); i++) {
            if ((divisible(arrayA, i) && indivisible(arrayB, i)) ||
               (divisible(arrayB, i) && indivisible(arrayA, i))) {
                answer = i;
            }
        }
        
        return answer;
    }
    
}