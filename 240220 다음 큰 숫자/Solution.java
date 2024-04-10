class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        int binaryCount = count - 1;

        while (binaryCount != count) {
            n++;
            binaryCount = Integer.bitCount(n);
        }
        
        return n;
    }
}