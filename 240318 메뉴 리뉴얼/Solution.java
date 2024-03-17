import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<> ();
    Set<String> answer = new TreeSet<>();
    boolean[] visited;
    int[] maxCourses;
    
    public String[] solution(String[] orders, int[] course) {
        maxCourses = new int[course.length];
        
        for (String order : orders) {
            String[] arr = order.split("");
            Arrays.sort(arr);
            visited = new boolean[arr.length];
            
            dfs(arr, "", course, 0);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    void dfs(String[] arr, String c, int[] course, int startIdx) {        
        for (int i = 0; i < course.length; i++) {
            if (course[i] == c.length()) {
                int count = map.getOrDefault(c, 0) + 1;
                int max = maxCourses[i];
                
                map.put(c, count);
                
                if (count > 1 && count >= max) {
                    if (count != max) {
                        maxCourses[i] = count;
                        Iterator<String> iterator = answer.iterator();
                            
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            if (key.length() == course[i]) {
                                iterator.remove();
                            }
                        } 
                    }
                    
                    answer.add(c);
                }

                if (i == course.length - 1) return;
            }
        }
        
        if (c.length() == arr.length) return;
        
        for (int i = startIdx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, c + arr[i], course, i);
                visited[i] = false;
            }
        }
    }
}