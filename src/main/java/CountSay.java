/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class CountSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char pre = result.charAt(0);
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) != pre) {
                    //统计
                    sb.append(count);
                    sb.append(pre);
                    pre = result.charAt(j);
                    count = 1;
                } else {
                    count += 1;
                }
            }
            sb.append(count);
            sb.append(pre);
            result = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        CountSay cs = new CountSay();
        String res = cs.countAndSay(3);
        System.out.println(res);
//        for (int i = 1; i < 4; i++) {
//            String res = cs.countAndSay(i);
//            System.out.println(res);
//        }
    }
}
