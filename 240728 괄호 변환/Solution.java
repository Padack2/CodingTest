class Solution {
    public String solution(String w) {
        String answer = makeBracket(w);
        
        return answer;
    }
    
    String makeBracket(String w) {
        if ("".equals(w)) return "";
        
        int a = 0;
        int b = 0;
        
        String u = "";
        String v = "";
        
        int s = 0;
        boolean check = true;
        
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                s ++;
                a ++;
            } else {
                s --;
                b ++;
                if (s < 0) {
                    check = false;
                }
            }
            
            if (a == b) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }
        
        if (check) {
            return u + makeBracket(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(makeBracket(v));
        sb.append(')');
        sb.append(getReverseBracket(u.substring(1, u.length() - 1)));
        
        return sb.toString();
    }
    
    String getReverseBracket(String str) {
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
}