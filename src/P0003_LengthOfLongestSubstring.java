import common.*;
import java.util.HashMap;

public class P0003_LengthOfLongestSubstring {
    //这道题的暴力解法，定义一个字典，每次遍历字符时，检查当前字典中是否存在
    // 如果存在，那么此次，判断是之前的大还是现在的大
    // 如果不存在，当前个数+1，存入字符
    public static int lengthOfLongestSubstringBF(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean[] book = new boolean[128];
            int current = 0;
            for (int j = i; j < s.length(); j++) {
                if (book[s.charAt(j)])
                    break;
                else {
                    current++;
                    book[s.charAt(j)] = true;
                }
            }
            max = Math.max(current, max);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int Max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            //如果包含字符，则i向右移动，j为当前的位置
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j + 1);
            Max = Math.max(Max, j - i + 1);
        }
        return Max;
    }

    public static void main(String[] args) {
        T.eq(3, lengthOfLongestSubstring("abcabcbb"), "示例1");
        T.eq(1, lengthOfLongestSubstring("bbbbb"), "示例2");
        T.eq(3, lengthOfLongestSubstring("pwwkew"), "示例3");
        T.eq(0, lengthOfLongestSubstring(""), "示例4 空串");
        T.eq(6, lengthOfLongestSubstring("abcdef"), "示例5 全不同");
        T.eq(3, lengthOfLongestSubstringBF("abcabcbb"), "示例1 暴力");
        T.summary();
    }
}
