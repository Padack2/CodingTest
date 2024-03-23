import java.util.regex.Pattern;
import java.util.*;

class Solution {
    Set<Set<Integer>> answer = new HashSet<> ();
    
    public int solution(String[] user_id, String[] banned_id) {
        List<List<Integer>> banTarget = new ArrayList<>();
        
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replaceAll("\\*", "\\\\w");
            banTarget.add(new ArrayList<> ());
        }
        
        for (int i = 0; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                String pattern = banned_id[j];
                if (Pattern.matches(pattern, user_id[i])) {
                    banTarget.get(j).add(i);
                }
            }
        }
        
        dfs(new LinkedHashSet<>(), banTarget);
        
        return answer.size();
    }
    
    void dfs(Set<Integer> set, List<List<Integer>> banTarget) {
        if (set.size() == banTarget.size()) {
            answer.add(new HashSet<> (set));
        } else {
            for (int id : banTarget.get(set.size())) {
                if (set.add(id)) {
                    dfs(set, banTarget);
                    set.remove(id);
                }
            }
        }
    }
}