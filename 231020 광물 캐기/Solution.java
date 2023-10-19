import java.util.*;

class Solution {
    class MineralSet {
        public int weight = 0;
        public int diamond = 0;
        public int iron = 0;
        public int stone = 0;
        
        // 0: 다이아몬드, 1: 철, 2: 돌
        public int getEnergy(int pick) {
            if (pick == 0) {
                return diamond + iron + stone;
            }
            if (pick == 1) {
                return diamond * 5 + iron + stone;
            }
            return diamond * 25 + iron * 5 + stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxMine = picks[0] + picks[1] + picks[2];
        PriorityQueue<MineralSet> pq = new PriorityQueue<>((MineralSet o1, MineralSet o2) -> {
            return o2.weight - o1.weight;
        });

        for (int i = 0; i < minerals.length / 5 + 1; i++) {
            MineralSet ms = new MineralSet();
            
            for (int j = i * 5; j < i * 5 + 5; j++) {
                if (j == minerals.length) {
                    break;
                }
                
                if (minerals[j].equals("diamond")) {
                    ms.weight += 25;
                    ms.diamond ++;
                } else if (minerals[j].equals("iron")) {
                    ms.weight += 5;
                    ms.iron ++;
                } else {
                    ms.weight ++;
                    ms.stone ++;
                }
            }
            pq.offer(ms);
            
            if (pq.size() == maxMine) {
                break;
            }
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < picks[j]; i++) {
                if (pq.size() > 0) {
                    answer += pq.poll().getEnergy(j);
                }
            }
        }
        
        return answer;
    }
}