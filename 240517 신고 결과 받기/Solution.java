import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> dupleCheck = new HashSet<> ();
        Map<String, List<String>> reportMap = new HashMap<> ();
        Map<String, Integer> warningMap = new HashMap<> ();

        for (String r : report) {
            if (!dupleCheck.contains(r)) {
                dupleCheck.add(r);
                String[] s = r.split(" ");
                String user = s[0];
                String target = s[1];
                
                List<String> list = reportMap.getOrDefault(user, new ArrayList<String> ());
                list.add(target);
                reportMap.put(user, list);
                
                warningMap.put(target, warningMap.getOrDefault(target, 0) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            int result = 0;
            List<String> list = reportMap.getOrDefault(user, new ArrayList<String> ());
            
            for (String id : list) {
                if (warningMap.getOrDefault(id, 0) >= k) {
                    result ++;
                }
            }
            
            answer[i] = result;
        }
        
        return answer;
    }
}