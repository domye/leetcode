public class P3584_MaximumProduct {
    //    给你一个整数数组 nums 和一个整数 m。
    //    返回任意大小为 m 的 子序列 中首尾元素乘积的最大值。
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

            long x = nums[i];
            max = Math.max(max, Math.max(x * mn, x * mx));
        }
        return max;
    }

    public static void main(String[] args) {
        P3584_MaximumProduct solution = new P3584_MaximumProduct();
        T.eq(81L, solution.maximumProduct(new int[]{-1, -9, 2, 3, -2, -3, 1}, 1), "示例1");
        T.eq(20L, solution.maximumProduct(new int[]{1, 3, -5, 5, 6, -4}, 3), "示例2");
        T.summary();
    }
}
