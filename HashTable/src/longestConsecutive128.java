import java.util.HashSet;
import java.util.Set;

public class longestConsecutive128 {
//    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
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
        longestConsecutive128 solution = new longestConsecutive128();

        // 测试用例1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        double result1 = solution.longestConsecutive(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [100,4,200,1,3,2]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 4");
        System.out.println();

        // 测试用例2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        double result2 = solution.longestConsecutive(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [0,3,7,2,5,8,4,6,0,1]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 9");
        System.out.println();
    }

}