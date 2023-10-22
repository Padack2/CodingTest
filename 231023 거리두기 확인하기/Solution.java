class Solution {
    public int[] solution(String[][] places) {
        int[][] tempArr;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
                
        int[] answer = new int[places.length];
        
        for (int p = 0; p < places.length; p++) {
            String[] place = places[p];
            int check = 1;
            tempArr = new int[5][5];
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        tempArr[i][j] += 1;
                        for (int k = 0; k < 4; k++) {
                            if (i + dx[k] != 5 && j + dy[k] != 5
                                && i + dx[k] != -1 && j + dy[k] != -1) {
                                tempArr[i + dx[k]][j + dy[k]] += 1;
                            }
                        }
                    }
                    if (place[i].charAt(j) == 'X') {
                        tempArr[i][j] += -100;
                    }
                }
            }
            
            for (int i = 0; i < 5; i ++) {
                for (int j = 0; j < 5; j++) {
                    if (tempArr[i][j] >= 2) {
                        check = 0;
                    } 
                }
            }
            
            answer[p] = check;
        }

        return answer;
    }
}