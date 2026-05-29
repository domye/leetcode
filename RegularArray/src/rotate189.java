public class maxSubArray53 {
    public int maxSubArray(int[] nums) {
        //定义一个变量，存储最大值
        int max = nums[0];
        //再定义一个变量，存储和
        int sum = 0;
        //遍历数组
        for (int num : nums) {

            sum = sum + num;
            //有可能会有负数，如果加入这个值后值还没有原来的大
            sum = Math.max(sum, num);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArray53 solution = new maxSubArray53();

        // 测试示例1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("示例1测试结果: " + result1); // 期望输出: 6

        // 测试示例2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("示例2测试结果: " + result2); // 期望输出: 1

        // 测试示例3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("示例3测试结果: " + result3); // 期望输出: 23
    }
}
