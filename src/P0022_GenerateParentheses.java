import common.*;

import java.util.ArrayList;
import java.util.List;

public class P0022_GenerateParentheses {
    // 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    // 示例：n = 3 → ["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
        dfs(0, 0, n, path, ans); // 一开始没有填括号
        return ans;
    }

    // 目前填了 left 个左括号，right 个右括号
    // 思路和p75差不多
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if (right == n) { // 填完 2n 个括号
            ans.add(new String(path));
            return;
        }
        if (left < n) { // 可以填左括号
            path[left + right] = '('; // 直接覆盖
            dfs(left + 1, right, n, path, ans);
        }
        if (right < left) { // 可以填右括号
            path[left + right] = ')'; // 直接覆盖
            dfs(left, right + 1, n, path, ans);
        }
    }

    public static void main(String[] args) {
        P0022_GenerateParentheses s = new P0022_GenerateParentheses();
        T.eq(List.of("()"), s.generateParenthesis(1), "n=1");
        T.eq(List.of("(())", "()()"), s.generateParenthesis(2), "n=2");
        T.eq(List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                s.generateParenthesis(3), "n=3 示例");
        T.summary();
    }
}
