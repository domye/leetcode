public class P1456_MaxVowels {
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
    }

    public static void main(String[] args) {
        P1456_MaxVowels solution = new P1456_MaxVowels();
        T.eq(3, solution.maxVowels("abciiidef", 3), "示例1");
        T.eq(2, solution.maxVowels("aeiou", 2), "示例2");
        T.eq(2, solution.maxVowels("leetcode", 3), "示例3");
        T.eq(0, solution.maxVowels("rhythms", 4), "示例4 无元音");
        T.eq(1, solution.maxVowels("tryhard", 4), "示例5");
        T.summary();
    }
}
