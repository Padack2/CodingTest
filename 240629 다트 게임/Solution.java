import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("(\\d{1,2})([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);

        ArrayList<Integer> scores = new ArrayList<>();
        
        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);

            switch (bonus) {
                case "S":
                    score = (int) Math.pow(score, 1);
                    break;
                case "D":
                    score = (int) Math.pow(score, 2);
                    break;
                case "T":
                    score = (int) Math.pow(score, 3);
                    break;
            }

            if (option.equals("*")) {
                score *= 2;
                if (!scores.isEmpty()) {
                    int previousIndex = scores.size() - 1;
                    scores.set(previousIndex, scores.get(previousIndex) * 2);
                }
            } else if (option.equals("#")) {
                score *= -1;
            }

            scores.add(score);
        }

        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}