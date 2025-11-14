import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {
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
        // 测试用例1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [1,1,1], k = 2");
        System.out.println("输出: " + subarraySum(nums1, k1));
        System.out.println("预期: 2");
        System.out.println();

        // 测试用例2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [1,2,3], k = 3");
        System.out.println("输出: " + subarraySum(nums2, k2));
        System.out.println("预期: 2");
        System.out.println();

        // 测试用例3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("测试用例3:");
        System.out.println("输入: nums = [1,-1,0], k = 0");
        System.out.println("输出: " + subarraySum(nums3, k3));
        System.out.println("预期: 3");
        System.out.println();

        // 测试用例4 - 空数组
        int[] nums4 = {};
        int k4 = 1;
        System.out.println("测试用例4:");
        System.out.println("输入: nums = [], k = 1");
        System.out.println("输出: " + subarraySum(nums4, k4));
        System.out.println("预期: 0");
        System.out.println();

        // 测试用例5 - 包含负数
        int[] nums5 = {1, -1, 1, -1, 1};
        int k5 = 0;
        System.out.println("测试用例5:");
        System.out.println("输入: nums = [1,-1,1,-1,1], k = 0");
        System.out.println("输出: " + subarraySum(nums5, k5));
        System.out.println("预期: 6");
    }
}
