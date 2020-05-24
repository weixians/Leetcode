/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Sqrtx {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static void main(String[] args) {
        Sqrtx tc = new Sqrtx();
        System.out.println(Integer.MAX_VALUE);
        System.out.println((289398 * 289398));
        System.out.println(tc.mySqrt(2147395600));
        System.out.println(Math.sqrt(2147395600));
    }
}
