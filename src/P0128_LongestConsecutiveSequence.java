import common.*;
import java.util.HashSet;
import common.*;
import java.util.Set;

public class P0128_LongestConsecutiveSequence {
    //    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    //    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    public int longestConsecutive(int[] nums) {
        Set<Integer> a = new HashSet<>();
        for (int num : nums) {
            a.add(num);
        }
        int max = 0;
        for (int x : a) {
            if (a.contains(x - 1))
                continue;
            int length = 1;
            int num = x;
            while (a.contains(num + 1)) {
                num++;
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }

    public static void main(String[] args) {
        P0128_LongestConsecutiveSequence solution = new P0128_LongestConsecutiveSequence();
        T.eq(4, solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), "示例1");
        T.eq(9, solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}), "示例2");
        T.summary();
    }
}
