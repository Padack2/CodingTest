import java.util.*;

class Solution {
    class Time {
        public int hour;
        public int minute;
        
        Time (int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
            
            if (minute > 60) {
                this.minute -= 60;
                this.hour ++;
            }
        }
        
        public int compare (Time target) {
            if (this.hour != target.hour) {
                return this.hour - target.hour;
            }
            return this.minute - target.minute;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Time> pq1 = new PriorityQueue<Time> (
            (Time a, Time b) -> {
                return a.compare(b);
            }
        );
        
       PriorityQueue<Time> pq2 = new PriorityQueue<Time> (
            (Time a, Time b) -> {
                return a.compare(b);
            }
        );

        for (String[] times : book_time) {
            String[] startTimeStr = times[0].split(":");
            String[] endTimeStr = times[1].split(":");
            
            Time startTime = new Time(Integer.parseInt(startTimeStr[0]),
                                      Integer.parseInt(startTimeStr[1]));
            Time endTime = new Time(Integer.parseInt(endTimeStr[0]),
                                      Integer.parseInt(endTimeStr[1]) + 10);
            
            pq1.offer(startTime);
            pq2.offer(endTime);
        }
        
        int current = 0;
        
        while (pq2.size() > 0 && pq1.size() > 0) {
            if (pq1.peek().compare(pq2.peek()) < 0) {
                current ++;
                pq1.poll();
                
                if (answer < current) {
                    answer = current;
                }
            } else if (pq1.peek().compare(pq2.peek()) == 0) {
                pq1.poll();
                pq2.poll();
            } else {
                pq2.poll();
                current --;
            }
        }

        return answer;
    }
}