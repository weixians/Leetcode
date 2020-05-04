/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int lastpos = nums.length - 1;
        for (int i = 0; i <= lastpos; i++) {
            if (nums[i] == val) {
                while (lastpos > 0 && lastpos > i) {
                    if (nums[lastpos] != val) {
                        break;
                    } else {
                        lastpos--;
                    }
                }
                int temp = nums[lastpos];
                nums[lastpos] = nums[i];
                nums[i] = temp;
                lastpos--;
            }
        }
        return lastpos + 1;
    }

    public void test(int[] nums, int val) {
        int len = removeElement(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        re.test(nums, val);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        re.test(nums, val);

        nums = new int[]{1};
        val = 1;
        re.test(nums, val);

        nums = new int[]{4, 5};
        val = 5;
        re.test(nums, val);
    }
}
