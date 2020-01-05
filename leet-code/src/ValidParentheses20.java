import java.util.Stack;

public class ValidParentheses20 {
    // 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/

    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if ('(' == c) stack.push(')');
            else if ('{' == c) stack.push('}');
            else if ('[' == c) stack.push(']');
            else if (stack.empty() || c != (char)stack.pop()) return false;
        }
        return stack.empty();
    }
}
