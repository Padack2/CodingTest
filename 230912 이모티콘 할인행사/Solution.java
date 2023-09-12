import java.util.*;

class Solution {
    int[] discount = {10, 20, 30, 40};
    int[] maxValue = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        calculateMaxValue(0, users, emoticons, new int[emoticons.length]);
        
        return maxValue;
    }
    
    public void calculateMaxValue(int depth, int[][] users, int[] emoticons, int[] totalDiscount) {
        if(depth == totalDiscount.length) {
            
            int service = 0;
            int money = 0;

            for(int i = 0; i < users.length; i ++) {
                int sum = 0;
                
                for(int e = 0; e < emoticons.length; e ++) {
                    if(totalDiscount[e] >= users[i][0]) {
                        sum += emoticons[e] * (100 - totalDiscount[e]) / 100;
                    }
                }

                if(sum >= users[i][1]) service ++;
                else money += sum;
            }
            
            if (maxValue[0] < service || (maxValue[0] == service && maxValue[1] < money)) {
                maxValue = new int[] {service, money};
            }
            return;
        }
        
        for(int i = 0; i < discount.length; i ++) {
            totalDiscount[depth] = discount[i];
            calculateMaxValue(depth + 1, users, emoticons, totalDiscount);
        }
    }
}