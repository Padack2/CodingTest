class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            str = str.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            if (str.replaceAll("aya|ye|woo|ma", "").equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}