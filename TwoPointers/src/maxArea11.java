public class maxArea11 {
//    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//    返回容器可以储存的最大水量。
//
//    说明：你不能倾斜容器。

    public int maxArea(int[] height) {
        int n = height.length - 1;
        int a = 0;
        int b = n;
        int max = Integer.MIN_VALUE;
        while (a < b) {
            if (height[a] < height[b]) {
                int s = n * height[a];
                max = Math.max(s, max);
                a++;
            } else {
                int s = n * height[b];
                max = Math.max(s, max);
                b--;
            }
            n--;
        }
        return max;
    }

    public static void main(String[] args) {
        maxArea11 solution = new maxArea11();

        // 测试用例1
        int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        double result1 = solution.maxArea(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [1,8,6,2,5,4,8,3,7]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 49");
        System.out.println();

        // 测试用例2
        int[] nums2 = {1, 1};
        double result2 = solution.maxArea(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [1,1]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 1");
        System.out.println();
    }

}