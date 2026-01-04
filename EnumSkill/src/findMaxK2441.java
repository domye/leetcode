import java.util.HashMap;

public class findMaxK2441 {
//    给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
//
//    返回正整数 k ，如果不存在这样的整数，返回 -1 。

    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i : nums) {
            if (map.containsKey(0 - i))
                max = Math.max(Math.abs(i), max);
            map.put(i, 0);
        }
        return max;

    }

    public static void main(String[] args) {
        findMaxK2441 solution = new findMaxK2441();

        // 测试用例1
        int[] nums1 = {-1, 2, -3, 3};
        double result1 = solution.findMaxK(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [-1,2,-3,3]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 3");
        System.out.println();

        // 测试用例2
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        double result2 = solution.findMaxK(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [-1,10,6,7,-7,1]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 7");
        System.out.println();
    }

}