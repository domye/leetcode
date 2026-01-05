package easy;

public class maximumDifference2016 {
//    给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
//
//    返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。

    public int maximumDifference(int[] nums) {
        int result = -1;
        int minNum = nums[0];
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            if (num > minNum)
                result = Math.max(result, num - minNum);

        }
        return result;
    }

    public static void main(String[] args) {
        maximumDifference2016 solution = new maximumDifference2016();

        // 测试用例1
        int[] nums1 = {9, 4, 3, 2};
        int result1 = solution.maximumDifference(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [9,4,3,2]");
        System.out.println("输出: " + result1);
        System.out.println("期望: -1");
        System.out.println();

        // 测试用例2
        int[] nums2 = {1, 5, 2, 10};
        int result2 = solution.maximumDifference(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [1,5,2,10]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 9");
        System.out.println();


    }

}