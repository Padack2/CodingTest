class Solution {
    public long solution(int n, int[] times) {
        long end = (long)Math.max(times[0], times[1]) * n;
        long start = 1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long currentValue = 0;
            
            for (int time : times) {
                currentValue += mid / time;
            }
            
            if (currentValue < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}