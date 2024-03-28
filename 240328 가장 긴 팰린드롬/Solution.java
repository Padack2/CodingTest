class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = 0; j + i < s.length(); j++) {
                if (isPalindrome(s, j, j + i)) return i + 1;
            }
        }

        return 1;
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        
        return true;
    }
}