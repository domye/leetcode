import common.*;

public class P0005_LongestPalindromicSubstring {
    //    给你一个字符串 s，找到 s 中最长的回文子串。
    //    示例 1：s = "babad" → "bab"（"aba" 也是合法答案）
    //    示例 2：s = "cbbd" → "bb"
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // 奇数长度回文
            int len2 = expandAroundCenter(s, i, i + 1);  // 偶数长度回文
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        P0005_LongestPalindromicSubstring s = new P0005_LongestPalindromicSubstring();
        T.eq("aba", s.longestPalindrome("babad"), "示例1 babad → bab/aba 皆可");
        T.eq("bb", s.longestPalindrome("cbbd"), "示例2 cbbd → bb");
        T.eq("a", s.longestPalindrome("a"), "示例3 单字符");
        T.eq("", s.longestPalindrome(""), "示例4 空串");
        T.summary();
    }
}
