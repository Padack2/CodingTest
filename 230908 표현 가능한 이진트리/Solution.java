import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0 ; i < numbers.length; i++) {
            String binaryNumber = getBinaryNumber(numbers[i]);
            answer[i] = isPerfectBinaryTree(binaryNumber)? 1 : 0;
        }
        
        return answer;
    }
    
    private String getBinaryNumber(long num) {
        String binaryNumber = "";
        
        while (num > 0) {
            binaryNumber = (num % 2) + binaryNumber;
            num = num / 2;
        }
        
        // 이진 트리 만들기 위해 이진수 길이 2의 제곱 - 1로 맞추기
        while (!validateBinaryNumberLength(binaryNumber.length() + 1)) {
            binaryNumber = "0" + binaryNumber;
        }
        
        return binaryNumber;
    }
    
    private boolean validateBinaryNumberLength(int num) {
        return (num & (num - 1)) == 0;
    }
    
    private boolean isPerfectBinaryTree (String tree) {
        if (tree.length() == 1) return true;
        else {
            return validateChildNodes(tree);
        }
    }
    
    private boolean validateNodes(boolean parent, String childA, String childB) {
        boolean check = true;
        boolean checkChildA = true;
        boolean checkChildB = true;
        // 부모가 0인데 자식이 있는 경우 false
        if (!parent) {
            if (childA.contains("1") || childB.contains("1")) {
                return false;
            } else {
                return true;
            }
        } else {
            checkChildA = validateChildNodes(childA);
            checkChildB = validateChildNodes(childB);
        }
        
        return check && checkChildA && checkChildB;
    }
    
    private boolean validateChildNodes(String node) {
        if (node.length() == 1) return true;
        
        int rootIndex = node.length() / 2;

        return validateNodes(getBinaryValue(node.charAt(rootIndex)), node.substring(0, rootIndex), node.substring(rootIndex + 1));
    }
    
    private boolean getBinaryValue(char str) {
        return str == '1';
    }
}