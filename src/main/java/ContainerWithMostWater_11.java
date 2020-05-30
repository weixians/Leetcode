/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class ContainerWithMostWater_11 {
    /**
     * Brute Force办法，效率一般
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 官方答案，5ms
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int maxL = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] < maxL) {
                continue;
            }
            maxL = height[i];
            int maxR = 0;
            for (int j = height.length - 1; j >= i + 1; j--) {
                if (height[j] < maxR) {
                    continue;
                }
                maxR = height[j];
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater_11 tc = new ContainerWithMostWater_11();
        int[] height = new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        System.out.println(tc.maxArea2(height));
    }
}
