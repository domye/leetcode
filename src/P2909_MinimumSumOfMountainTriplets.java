import common.*;

public class P2909_MinimumSumOfMountainTriplets {
    //    给你一个下标从 0 开始的整数数组 nums 。
    //    如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
    //    i < j < k
    //    nums[i] < nums[j] 且 nums[k] < nums[j]
    //    请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
    public int minimumSum(int[] nums) {
        int length = nums.length;
        int[] a = new int[length + 1];
        int ans = Integer.MAX_VALUE;
        // 初始化
        a[0] = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int i = 1; i <= length - 2; i++)
            a[i] = Math.min(nums[i - 1], a[i - 1]);
        for (int i = length - 2; i >= 1; i--) {
            b = Math.min(nums[i + 1], b);
            if (a[i] < nums[i] && b < nums[i])
                ans = Math.min(ans, nums[i] + a[i] + b);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        P2909_MinimumSumOfMountainTriplets solution = new P2909_MinimumSumOfMountainTriplets();
        T.eq(9, solution.minimumSum(new int[]{8, 6, 1, 5, 3}), "示例1");
        T.eq(13, solution.minimumSum(new int[]{5, 4, 8, 7, 10, 2}), "示例2");
        T.eq(-1, solution.minimumSum(new int[]{4, 3, 2, 1}), "示例3 无山形");
        T.summary();
    }
}
