class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int j = 0; j < skill_trees.length; j++) {
            String tree = skill_trees[j];
            int index = 0;

            for (int i = 0; i < skill.length(); i++) {
                int temp = tree.indexOf(skill.charAt(i));
                if (temp != -1 && (index == -1 || index > temp)) {
                    break;
                }
                index = temp;
                if (i == skill.length() - 1) {
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}