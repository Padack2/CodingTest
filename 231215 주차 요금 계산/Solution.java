import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new TreeMap<>();
        Map<String, String> startTimeMap = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            if (record[2].equals("IN")) {
                startTimeMap.put(record[1], record[0]);
            } else {
                int usageTime = getUsageTime(startTimeMap.get(record[1]), record[0]);
                timeMap.put(record[1], timeMap.getOrDefault(record[1], 0) + usageTime);
                startTimeMap.remove(record[1]);
            }
        }
        
        Set<String> keySet = startTimeMap.keySet();

        for (String key : keySet) {
            int usageTime = getUsageTime(startTimeMap.get(key), "23:59");
            timeMap.put(key, timeMap.getOrDefault(key, 0) + usageTime);
        }
        
        int[] answer = new int[timeMap.size()];
        keySet = timeMap.keySet();
        
        int index = 0;
        for (String key : keySet) {
            int usageTime = timeMap.get(key) - fees[0];
            int fee = 0;
            if (usageTime <= 0) {
                fee = fees[1];
            } else {
                int unit = (int)Math.ceil((double)usageTime / fees[2]);
                fee = fees[1] + unit * fees[3];
            }
            
            answer[index++] = fee;
        }
        
        return answer;
    }
    
    public int getUsageTime(String startTime, String endTime) {
        String[] t1 = startTime.split(":");
        String[] t2 = endTime.split(":");
        int time = Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
        
        if (time < 0) {
            time += 60;
            time += 60 * (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]) - 1);
        } else {
            time += 60 * (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]));
        }
        
        return time;
    }
}