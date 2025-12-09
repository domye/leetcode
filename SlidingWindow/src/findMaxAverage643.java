public class findMaxAverage643 {
//    给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
//
//    请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
//
//    任何误差小于 10-5 的答案都将被视为正确答案。

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        //找出前k个数组，并求和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        //遍历后面的数组
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;

    }

    public static void main(String[] args) {
        findMaxAverage643 solution = new findMaxAverage643();

        // 测试用例1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        double result1 = solution.findMaxAverage(nums1, k1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [1,12,-5,-6,50,3], k = 4");
        System.out.println("输出: " + result1);
        System.out.println("期望: 12.75");
        System.out.println();

        // 测试用例2
        int[] nums2 = {5};
        int k2 = 1;
        double result2 = solution.findMaxAverage(nums2, k2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [5], k = 1");
        System.out.println("输出: " + result2);
        System.out.println("期望: 5.00000");
        System.out.println();
    }

}