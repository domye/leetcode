package easy;

import java.util.HashMap;

public class numIdenticalPairs1512 {
    //    给你一个整数数组 nums 。
//
//    如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
//
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
        int[] nums = {1,2,3,1,1,3};
        numIdenticalPairs1512 solution = new numIdenticalPairs1512();
        int result = solution.numIdenticalPairs(nums);
        System.out.println(result);
    }
}
