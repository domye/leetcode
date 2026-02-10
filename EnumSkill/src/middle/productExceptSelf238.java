package middle;

import java.util.Arrays;

public class productExceptSelf238 {
//    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
//
//    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        int[] suf = new int[length];
//        Arrays.fill(pre, 1);
//        Arrays.fill(suf, 1);
        int mo = length - 2;
        int qi = 1;
        pre[0] = 1;
        suf[length - 1] = 1;
        for (int i = 0; i < length - 1; i++) {
            System.out.println(pre[qi - 1] + "+" + nums[qi - 1]);
            pre[qi] = pre[qi - 1] * nums[qi - 1];
            suf[mo] = suf[mo + 1] * nums[mo + 1];
            mo--;
            qi++;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++)
            result[i] = pre[i] * suf[i];
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(suf));
        System.out.println(Arrays.toString(result));
        return null;
    }

    public static void main(String[] args) {
        productExceptSelf238 solution = new productExceptSelf238();

        // 测试用例1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [1,2,3,4]");
        System.out.println("输出: " + result1);
        System.out.println("期望: [24,12,8,6]");
        System.out.println();

        // 测试用例2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [-1, 1, 0, -3, 3]");
        System.out.println("输出: " + result2);
        System.out.println("期望: [0,0,9,0,0]");
        System.out.println();
    }

}