package middle;

public class maximumProduct3584 {
//    给你一个整数数组 nums 和一个整数 m。
//
//    返回任意大小为 m 的 子序列 中首尾元素乘积的最大值。
//
//    子序列 是可以通过删除原数组中的一些元素（或不删除任何元素），且不改变剩余元素顺序而得到的数组。

    public long maximumProduct(int[] nums, int m) {
        //题目可以转化为第一个数的下标和最终数的下标相差m-1
        long max = Long.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i = m - 1; i < nums.length; i++) {
            int num = nums[i - m + 1];
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);

            long x=nums[i];
            max = Math.max(max, Math.max(x * mn, x * mx));
        }
        return max;
    }

    public static void main(String[] args) {
        maximumProduct3584 solution = new maximumProduct3584();

        // 测试用例1
        int[] nums1 = {-1, -9, 2, 3, -2, -3, 1};
        int m1 = 1;
        double result1 = solution.maximumProduct(nums1, m1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [-1,-9,2,3,-2,-3,1]  m=1");
        System.out.println("输出: " + result1);
        System.out.println("期望: 81");
        System.out.println();

        // 测试用例2
        int[] nums2 = {1, 3, -5, 5, 6, -4};
        int m2 = 3;
        double result2 = solution.maximumProduct(nums2, m2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [1,3,-5,5,6,-4]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 20");
        System.out.println();
    }

}