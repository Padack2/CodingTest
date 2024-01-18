class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max = health;
        int prev = 0;
        
        for (int[] attack : attacks) {
            int healTime = attack[0] - prev - 1;
            prev = attack[0];
            
            if (health < max) {
                int bonus = healTime / bandage[0] * bandage[2];
                health = Math.min(max, health + bandage[1] * healTime + bonus);
            }
            
            health -= attack[1];

            if (health <= 0) {
                return -1;
            }
        }
        
        return health;
    }
}