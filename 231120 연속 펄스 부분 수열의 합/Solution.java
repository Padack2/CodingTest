class Solution {
    public long solution(int[] sequence) {
        // 1부터 시작했을 경우
        long[] positive = new long[sequence.length];
        // -1부터 시작했을 경우
        long[] negative = new long[sequence.length];
        
        positive[0] = sequence[0];
        negative[0] = sequence[0] * -1;
        
        long max = Math.max(positive[0], negative[0]);
        
        for (int i = 1; i < sequence.length; i++) {
            long seq = sequence[i] * (i % 2 == 1? -1 : 1);
            positive[i] = Math.max(seq, positive[i - 1] + seq);
            negative[i] = Math.max(seq * -1, negative[i - 1] - seq);
            
            max = Math.max(positive[i], max);
            max = Math.max(negative[i], max);
        }
        
        return max;
    }
}