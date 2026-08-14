import common.*;
import java.util.HashMap;

public class P1512_NumberOfGoodPairs {
    //    给你一个整数数组 nums 。
    //    如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
    //    返回好数对的数目。
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int x : nums) {
            int c = map.getOrDefault(x, 0);
            count += c;
            map.put(x, c + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        P1512_NumberOfGoodPairs solution = new P1512_NumberOfGoodPairs();
        T.eq(4, solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}), "示例1");
        T.eq(6, solution.numIdenticalPairs(new int[]{1, 1, 1, 1}), "示例2");
        T.eq(0, solution.numIdenticalPairs(new int[]{1, 2, 3}), "示例3 无重复");
        T.summary();
    }
}
