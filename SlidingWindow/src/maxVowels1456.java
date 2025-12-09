public class maxVowels1456 {

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int ans = 0;
        int temp = 0;
        int left = 0;
        // 滑动窗口方法：跟踪大小为k的窗口中的元音字母
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                temp++;
            }

            if (i >= k) {
                char out = s.charAt(left);
                if (isVowel(out)) {
                    temp--;
                }
                left++;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
        // 处理完前k个字符后，滑动窗口并更新元音计数
    }

    public static void main(String[] args) {
        maxVowels1456 solution = new maxVowels1456();

        // 测试用例1
        String test1 = "abciiidef";
        int k1 = 3;
        int result1 = solution.maxVowels(test1, k1);
        System.out.println("测试用例1:");
        System.out.println("输入: s = \"" + test1 + "\", k = " + k1);
        System.out.println("输出: " + result1);
        System.out.println("期望: 3");
        System.out.println();

        // 测试用例2
        String test2 = "aeiou";
        int k2 = 2;
        int result2 = solution.maxVowels(test2, k2);
        System.out.println("测试用例2:");
        System.out.println("输入: s = \"" + test2 + "\", k = " + k2);
        System.out.println("输出: " + result2);
        System.out.println("期望: 2");
        System.out.println();

        // 测试用例3
        String test3 = "leetcode";
        int k3 = 3;
        int result3 = solution.maxVowels(test3, k3);
        System.out.println("测试用例3:");
        System.out.println("输入: s = \"" + test3 + "\", k = " + k3);
        System.out.println("输出: " + result3);
        System.out.println("期望: 2");
        System.out.println();

        // 测试用例4
        String test4 = "rhythms";
        int k4 = 4;
        int result4 = solution.maxVowels(test4, k4);
        System.out.println("测试用例4:");
        System.out.println("输入: s = \"" + test4 + "\", k = " + k4);
        System.out.println("输出: " + result4);
        System.out.println("期望: 0");
        System.out.println();

        // 测试用例5
        String test5 = "tryhard";
        int k5 = 4;
        int result5 = solution.maxVowels(test5, k5);
        System.out.println("测试用例5:");
        System.out.println("输入: s = \"" + test5 + "\", k = " + k5);
        System.out.println("输出: " + result5);
        System.out.println("期望: 1");
        System.out.println();
    }
}