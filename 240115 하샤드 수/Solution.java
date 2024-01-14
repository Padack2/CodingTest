class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int y = x;
        
        while (y > 0) {
            int remain = y % 10;
            sum += remain;
            y /= 10;
        }
        
        
        return x % sum == 0;
    }
}