import common.*;
import java.util.HashMap;

public class P0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 题目给了我一个整数数组，要求数组中找到两个相加为目标值的下表
        // 最容易想到的方法是暴力，但这种算法时间复杂度为n2
        // 可以通过hash来降低时间复杂度
        HashMap<Integer, Integer> map = new HashMap<>();
        // for循环遍历，如果目标值-此数的值在hash中不存在，则存储于hash中
        for (int i = 0; i < nums.length; i++) {
            //求与该数相加所需要的值
            int sign = target - nums[i];
            //如果hash中存在该数，则返回
            if (map.containsKey(sign))
                return new int[]{i, map.get(sign)};
            else
                map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return new int[]{i, j};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        P0001_TwoSum solution = new P0001_TwoSum();
        T.eq(new int[]{1, 0}, solution.twoSum(new int[]{2, 7, 11, 15}, 9), "示例1");
        T.eq(new int[]{0, 1}, solution.twoSumBF(new int[]{2, 7, 11, 15}, 9), "示例1 暴力");
        T.summary();
    }
}
