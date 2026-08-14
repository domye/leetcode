import common.*;
import java.util.HashMap;

public class P2441_FindMaxK {
    //    给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
    //    返回正整数 k ，如果不存在这样的整数，返回 -1 。
    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i : nums) {
            if (map.containsKey(-i))
                max = Math.max(Math.abs(i), max);
            map.put(i, 0);
        }
        return max;
    }

    public static void main(String[] args) {
        P2441_FindMaxK solution = new P2441_FindMaxK();
        T.eq(3, solution.findMaxK(new int[]{-1, 2, -3, 3}), "示例1");
        T.eq(7, solution.findMaxK(new int[]{-1, 10, 6, 7, -7, 1}), "示例2");
        T.eq(-1, solution.findMaxK(new int[]{-10, 8, 6, 7, -2, -3}), "示例3 无匹配");
        T.summary();
    }
}
