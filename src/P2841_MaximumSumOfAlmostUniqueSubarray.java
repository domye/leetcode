import common.*;
import java.util.Arrays;
import common.*;
import java.util.List;

public class P2841_MaximumSumOfAlmostUniqueSubarray {
    //    给你一个整数数组 nums 和两个正整数 m 和 k 。
    //    请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
    //    如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
    //    子数组指的是一个数组中一段连续 非空 的元素序列。
    public long maxSum(List<Integer> nums, int m, int k) {
        return 1L; // TODO 未完成
    }

    public static void main(String[] args) {
        P2841_MaximumSumOfAlmostUniqueSubarray solution = new P2841_MaximumSumOfAlmostUniqueSubarray();
        T.eq(18L, solution.maxSum(Arrays.asList(2, 6, 7, 3, 1, 7), 3, 4), "示例1");
        T.eq(23L, solution.maxSum(Arrays.asList(5, 9, 9, 2, 4, 5, 4), 1, 3), "示例2");
        T.eq(0L, solution.maxSum(Arrays.asList(1, 2, 1, 2, 1, 2, 1), 3, 3), "示例3");
        T.summary();
    }
}
