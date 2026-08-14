import common.*;

public class P2016_MaximumDifference {
    //    给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
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
        P2016_MaximumDifference solution = new P2016_MaximumDifference();
        T.eq(-1, solution.maximumDifference(new int[]{9, 4, 3, 2}), "示例1 无满足");
        T.eq(9, solution.maximumDifference(new int[]{1, 5, 2, 10}), "示例2");
        T.summary();
    }
}
