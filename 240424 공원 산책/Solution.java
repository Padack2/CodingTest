import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Map<String, Integer> dirMapper = Map.of(
        "E", 0,
        "W", 1,
        "N", 2,
        "S", 3
    );
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = getStart(park);
        
        for (String route : routes) {
            String[] r = route.split(" ");
            int dir = dirMapper.get(r[0]);
            int distance = Integer.parseInt(r[1]);
            
            int nx = answer[1] + dx[dir] * distance;
            int ny = answer[0] + dy[dir] * distance;
            
            if (nx >= 0 && ny >= 0 && ny < park.length && nx < park[0].length() &&
                   isSafe(park, answer[0], answer[1], dir, distance)) {
                answer[0] = ny;
                answer[1] = nx;
            }
        }
 
        return answer;
    }
    
    public int[] getStart(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[] {i, j};
                }
            }
        }
        
        return null;
    }
    
    public boolean isSafe(String[] park, int y, int x, int dir, int distance) {
        for (int i = 1 ; i <= distance; i ++ ){
            int ny = y + i * dy[dir];
            int nx = x + i * dx[dir];

            if (park[ny].charAt(nx) == 'X') {
                return false;
            }
        }
        
        return true;
    }
}