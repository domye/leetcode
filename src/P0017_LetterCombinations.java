import common.*;

import java.util.ArrayList;
import java.util.List;

public class P0017_LetterCombinations {
    // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    // 示例 1：digits = "23" → ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    // 示例 2：digits = "2" → ["a","b","c"]
    private static final String[] MAPPING = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }

        List<String> ans = new ArrayList<>();
        char[] path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        dfs(0, ans, path, digits.toCharArray());
        return ans;
    }

    private void dfs(int i, List<String> ans, char[] path, char[] digits) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        char[] test = MAPPING[digits[i] - '0'].toCharArray();
        for (char c : test) {
            path[i] = c;
            dfs(i + 1, ans, path, digits);
        }
    }

    public static void main(String[] args) {
        P0017_LetterCombinations s = new P0017_LetterCombinations();
        T.eq(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
                s.letterCombinations("23"), "示例1 digits=23");
        T.eq(List.of("a", "b", "c"), s.letterCombinations("2"), "示例2 digits=2");
        T.eq(List.of(), s.letterCombinations(""), "示例3 空输入");
        T.summary();
    }
}
