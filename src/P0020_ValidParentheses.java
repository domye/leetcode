import common.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0020_ValidParentheses {
    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //    有效字符串需满足：左括号必须用相同类型的右括号闭合；左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 遇到右括号：栈空说明缺左括号，直接不合法
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(')
                        || (c == ']' && top != '[')
                        || (c == '}' && top != '{'))
                    return false;
            }
        }
        return stack.isEmpty(); // 全配完才算合法
    }

    public static void main(String[] args) {
        P0020_ValidParentheses s = new P0020_ValidParentheses();
        T.eq(true, s.isValid("()"), "示例1 成对");
        T.eq(true, s.isValid("()[]{}"), "示例2 多类括号");
        T.eq(false, s.isValid("(]"), "示例3 类型不匹配");
        T.eq(false, s.isValid("([)]"), "示例4 顺序错误");
        T.eq(true, s.isValid("{[]}"), "示例5 嵌套");
        T.eq(true, s.isValid(""), "示例6 空串");
        T.summary();
    }
}
