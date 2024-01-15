class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = getBinary(arr1[i] | arr2[i], n).replaceAll("1", "#").replaceAll("0", " ");
        }

        return answer;
    }
    
    public String getBinary (int num, int length) {
        String str = Integer.toBinaryString(num);
        
        while (str.length() < length) {
            str = "0" + str;
        }
        
        return str;
    }
}