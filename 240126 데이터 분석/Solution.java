import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> code = Arrays.asList("code", "date", "maximum", "remain");
        int sortByIdx = code.indexOf(sort_by);
        int extIdx = code.indexOf(ext);
        int condition = val_ext;

        data = Arrays.stream(data)
            .filter(item -> item[extIdx] < condition)
            .sorted((o1, o2) -> o1[sortByIdx] - o2[sortByIdx])
            .toArray(int[][]::new);  

        return data;
    }
}