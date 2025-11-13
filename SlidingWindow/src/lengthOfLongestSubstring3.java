import java.util.HashMap;

public class lengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        int Max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            //如果包含字符，则i向右移动，j为当前的位置
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            //不包含，那么存入当前的1

            map.put(s.charAt(j), j + 1);
            Max = Math.max(Max, j - i + 1);
        }
        //不包含，则记录

        return Max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring3 solution = new lengthOfLongestSubstring3();

        // 测试用例1
        String test1 = "abcabcbb";
        int result1 = lengthOfLongestSubstring(test1);
        System.out.println("测试用例1:");
        System.out.println("输入: " + test1);
        System.out.println("输出: " + result1);
        System.out.println("期望: 3");
        System.out.println();

        // 测试用例2
        String test2 = "bbbbb";
        int result2 = lengthOfLongestSubstring(test2);
        System.out.println("测试用例2:");
        System.out.println("输入: " + test2);
        System.out.println("输出: " + result2);
        System.out.println("期望: 1");
        System.out.println();

        // 测试用例3
        String test3 = "pwwkew";
        int result3 = lengthOfLongestSubstring(test3);
        System.out.println("测试用例3:");
        System.out.println("输入: " + test3);
        System.out.println("输出: " + result3);
        System.out.println("期望: 3");
        System.out.println();

        // 测试用例4：空字符串
        String test4 = "";
        int result4 = lengthOfLongestSubstring(test4);
        System.out.println("测试用例4:");
        System.out.println("输入: " + test4);
        System.out.println("输出: " + result4);
        System.out.println("期望: 0");
        System.out.println();

        // 测试用例5：所有字符都不同
        String test5 = "abcdef";
        int result5 = lengthOfLongestSubstring(test5);
        System.out.println("测试用例5:");
        System.out.println("输入: " + test5);
        System.out.println("输出: " + result5);
        System.out.println("期望: 6");
    }
}
