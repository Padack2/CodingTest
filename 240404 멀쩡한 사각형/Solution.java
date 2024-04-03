class Solution {
    public long solution(int w, int h) {
        long blocks = (long)w * h;
        
        int count = gcd(w, h);
        long cut = (long)(w + h) / count - 1;
        
        return blocks - cut * count;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}