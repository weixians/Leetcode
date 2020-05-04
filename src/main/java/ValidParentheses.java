import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        char pre = s.charAt(0);
        stack.push(pre);
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }
            pre = stack.pop();
            System.out.println("pre=" + pre + "," + "index0=" + stack.get(0));
            if (s.charAt(i) == ')') {
                if (pre != '(') {
                    stack.push(pre);
                    stack.push(s.charAt(i));
                }
            } else if (s.charAt(i) == ']') {
                if (pre != '[') {
                    stack.push(pre);
                    stack.push(s.charAt(i));
                }
            } else if (s.charAt(i) == '}') {
                if (pre != '{') {
                    stack.push(pre);
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(pre);
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParenthes = new ValidParentheses();
        String[] ss = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String s : ss) {
            boolean result = validParenthes.isValid(s);
            System.out.println(result);
        }
        String s = "{[]}";
        validParenthes.isValid(s);
    }
}
