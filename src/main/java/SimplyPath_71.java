import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SimplyPath_71 {
    /**
     * 使用两个栈实现。一个栈放置内容，并在期间去掉相关内容
     * 另一个栈负责反转剩余内容
     * 8ms
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (!dir.isEmpty()) {
                if (dir.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (!dir.equals(".")) {
                    stack.push(dir);
                }
            }
        }
        Stack<String> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        while (!stack2.isEmpty()) {
            sb.append("/").append(stack2.pop());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    /**
     * 使用list实现
     * 3ms
     *
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        String[] dirs = path.split("/");
        List<String> list = new ArrayList<>();
        for (String dir : dirs) {
            if (!dir.isEmpty()) {
                if (dir.equals("..")) {
                    if (!list.isEmpty())
                        list.remove(list.size() - 1);
                } else if (!dir.equals(".")) {
                    list.add(dir);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/").append(s);
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplyPath_71 tc = new SimplyPath_71();
        System.out.println(tc.simplifyPath("/a/./b/../../c/"));
    }
}
