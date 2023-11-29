import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> list = new ArrayList<>();
        Map<String, String> user = new HashMap<>();
        
        for (String record : records) {
            String[] info = record.split(" ");
            String action = info[0];
            String uid = info[1];
            
            if (info.length == 3) {
                String name = info[2];
                user.put(uid, name);
            }

            if ("Enter".equals(action)) {
                list.add(uid + "님이 들어왔습니다.");
            }
            if ("Leave".equals(action)) {
                list.add(uid + "님이 나갔습니다.");
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        
        for (int i = 0; i < answer.length; i++) {
            String uid = answer[i].split("님")[0];
            answer[i] = answer[i].replace(uid, user.get(uid));
        }
        
        return answer;
    }
}