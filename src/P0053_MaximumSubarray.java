import common.*;

public class P0053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //定义一个变量，存储最大值
        int max = nums[0];
        //再定义一个变量，存储和
        int sum = 0;
        //遍历数组
        for (int num : nums) {
            sum = sum + num;
            //有可能会有负数，如果加入这个值后值还没有原来的大
            sum = Math.max(sum, num);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        P0053_MaximumSubarray solution = new P0053_MaximumSubarray();
        T.eq(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), "示例1");
        T.eq(1, solution.maxSubArray(new int[]{1}), "示例2");
        T.eq(23, solution.maxSubArray(new int[]{5, 4, -1, 7, 8}), "示例3");
        T.summary();
    }
}
