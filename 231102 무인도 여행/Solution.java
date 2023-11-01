import java.util.*;
class Solution {
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();;
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(getSize(maps, i, j));
                }
            }
        }
            
        Collections.sort(answer);
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        if (answer.size() == 0) {
            return new int[] {-1};
        }
        
        return result;
    }
    
    int getSize(String[] maps, int y, int x) {
        visited[y][x] = true;
        int size = maps[y].charAt(x) - '0';
        
        for (int i = 0; i < 4; i++) {
            int searchX = x + dx[i];
            int searchY = y + dy[i];
            if (searchY != maps.length && searchX != maps[0].length() &&
                searchX >= 0 && searchY >= 0 &&
               !visited[searchY][searchX] && maps[searchY].charAt(searchX) != 'X') {
                size += getSize(maps, searchY, searchX);
            }
        }
        
        return size;
    }
}