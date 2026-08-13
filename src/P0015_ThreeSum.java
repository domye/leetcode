import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0015_ThreeSum {
    //    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    //    注意：答案中不可以包含重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        //首先，排序好数组,比如[-1, 0, 1, 2, -1, -4]，排序完变成[-4,-1,-1,0,1,2]
        Arrays.sort(nums);
        //只有正数加复数才有可能为0，所以可以最小的负数加第二小的负数，加最大的正数，如果小于0，把第二小的负数换成第三小的负数，直到等于或>0
        //这里我们定义一下最左和最右两个坐标
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 0; a < n - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // 跳过重复数字

            int b = a + 1;
            int c = n - 1;

            while (b < c) {
                int tmp = nums[a] + nums[b] + nums[c];
                if (tmp < 0)
                    b++;
                if (tmp > 0)
                    c--;
                if (tmp == 0) {
                    result.add(List.of(nums[a], nums[b], nums[c]));
                    for (b++; b < c && nums[b] == nums[b - 1]; b++) ; // 跳过重复数字
                    for (c--; c > b && nums[c] == nums[c + 1]; c--) ; // 跳过重复数字
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P0015_ThreeSum solution = new P0015_ThreeSum();
        T.eq(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}), "示例1");
        T.eq(List.of(List.of(0, 0, 0)), solution.threeSum(new int[]{0, 0, 0}), "示例2");
        T.summary();
    }
}
