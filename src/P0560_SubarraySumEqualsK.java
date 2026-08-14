import common.*;
import java.util.HashMap;
import common.*;
import java.util.Map;

public class P0560_SubarraySumEqualsK {
    public static int subarraySumBF(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //这里用到了前缀和加hash
    //    何为前缀和，就是数组中的连续的数累加，比如说[1,3,4],[1]为前缀，前缀和为1，[1,3]前缀和为4
    //    我们想要获取[3],只需要[1,3]-[1]就行了
    //    通过前缀和，任意范围的子数组 [i, j) 的元素和就等于 preSum[j] - preSum[i]
    //我们再查找其中满足相减为k的元素即可
    //这时候题目就被我们简化成了两数之和01.
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // 初始化前缀和为0的情况
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            // 如果存在前缀和为sum-k的情况，说明从某个位置到当前位置的和为k
            if (map.containsKey(sum - k))
                count += map.getOrDefault(sum - k, 0);
            // 更新当前前缀和的出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        T.eq(2, subarraySum(new int[]{1, 1, 1}, 2), "示例1");
        T.eq(2, subarraySum(new int[]{1, 2, 3}, 3), "示例2");
        T.eq(3, subarraySum(new int[]{1, -1, 0}, 0), "示例3");
        T.eq(0, subarraySum(new int[]{}, 1), "示例4 空数组");
        T.eq(6, subarraySum(new int[]{1, -1, 1, -1, 1}, 0), "示例5 含负数");
        T.eq(2, subarraySumBF(new int[]{1, 1, 1}, 2), "示例1 暴力");
        T.summary();
    }
}
