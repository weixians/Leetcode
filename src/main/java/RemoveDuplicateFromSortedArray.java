import org.junit.Assert;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 1;
        int pre = nums[0];
        boolean needChange = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                //与后面第一个与他不同的元素交换位置，并且修改i
                if (needChange) {
                    //当前元素与需要的元素不同，进行交换
                    //找到最后一个与当前元素相等的元素
                    int j = i;
                    while (j < nums.length) {
                        if (nums[j] == nums[i]) {
                            j++;
                        } else {
                            break;
                        }
                    }
                    if (j >= nums.length || nums[j] != nums[i]) {
                        j -= 1;
                    }
                    int temp = nums[j];
                    nums[j] = nums[length];
                    nums[length] = temp;
                    length += 1;
                    pre = temp;
                    i = j;
                    needChange = false;
                } else {
                    if (i != length) {
                        int temp = nums[i];
                        nums[i] = nums[length];
                        nums[length] = temp;
                        pre = temp;
                    } else {
                        pre = nums[i];
                    }
                    length += 1;
                }
            } else {
                if (!needChange) {
                    needChange = true;
                }
            }
        }
        return length;
    }

    public void test(int[] nums) {
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray rd = new RemoveDuplicateFromSortedArray();
        int[] nums = {1, 1, 2};
        rd.test(nums);
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        rd.test(nums);
    }
}
