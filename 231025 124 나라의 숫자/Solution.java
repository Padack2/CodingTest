class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int mod = (n % 3);
            
            if (mod == 0) {
                sb.insert(0, "4");
                n = n/3 - 1;
            } else {
                sb.insert(0, Integer.toString(mod));
                n /= 3;
            }
        }
        return sb.toString();
    }
}