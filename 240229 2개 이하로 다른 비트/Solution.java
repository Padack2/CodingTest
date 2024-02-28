class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String binary = Long.toString(numbers[i], 2);
                int pos = binary.lastIndexOf("0");
                
                if (pos == -1) {
                    answer[i] = Long.parseLong("10" + binary.substring(1), 2);
                } else {
                    String str = binary.substring(0, pos) + "10" + binary.substring(pos + 2);
                    answer[i] = Long.parseLong(str, 2);
                }
            }
        }
        
        return answer;
    }
}