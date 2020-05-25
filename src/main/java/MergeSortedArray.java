/**
 * Program: LeetCode
 * Description: Easy
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for (int i = 0; i < n; i++) {
            int n2 = nums2[i];
            for (int j = start; j < nums1.length; j++) {
                if ((j == 0 && n2 < nums1[j])) {
                    for (int k = m + i; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[j] = n2;
                    break;
                } else if (n2 < nums1[j]) {
                    for (int k = m + i; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[j] = n2;
                    start = j + 1;
                    break;
                } else if (j >= m + i) {
                    nums1[j] = n2;
                    start = j;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray tc = new MergeSortedArray();
        int[] nums1 = new int[]{2, 0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        tc.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }

        nums1 = new int[]{4, 5, 6, 0, 0, 0};
        m = 3;
        nums2 = new int[]{1, 2, 3};
        n = 3;
        tc.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
    }
}
