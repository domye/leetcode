import common.*;

public class P0643_MaximumAverageSubarray {
    //    给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
    //    请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
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
        P0643_MaximumAverageSubarray solution = new P0643_MaximumAverageSubarray();
        T.eq(12.75, solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 1e-5, "示例1");
        T.eq(5.0, solution.findMaxAverage(new int[]{5}, 1), 1e-5, "示例2");
        T.summary();
    }
}
