package middle;

public class specialTriplets3583 {
//    给你一个整数数组 nums。
//
//    特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)：
//
//            0 <= i < j < k < n，其中 n = nums.length
//    nums[i] == nums[j] * 2
//    nums[k] == nums[j] * 2
//    返回数组中 特殊三元组 的总数。
//
//    由于答案可能非常大，请返回结果对 109 + 7 取余数后的值。

    public int specialTriplets(int[] nums) {
        final int mod = 1_000_000_007;
        long sum = 0;
        //首先定义一个数组，去计算每个数字出现的个数

        int max = 0;
        for (int num : nums)
            max = Math.max(num, max);

        int[] a = new int[max + 1];

        for (int num : nums)
            a[num]++;

        //再定义一个数组，去存储该数字前有多少个该数字，简单来讲比如说遍历第i个数，该数组存储前i个数的数字总和
        //比如说2，2，6，2，8，下标分别为01234，则遍历到0的时候，b[2]为1，1时候为b[2]=2,遍历到3的时候则为3
        //同时，可以把a的个数减去，就相当于该数后面的数量
        int[] b = new int[max + 1];
        for (int num : nums) {
            a[num]--;
            if (num * 2 <= max)
                sum += (long) b[num * 2] * a[num * 2];
            b[num]++;

        }
        return (int) (sum % mod);
    }


    public static void main(String[] args) {
        specialTriplets3583 solution = new specialTriplets3583();

        // 测试用例1
        int[] nums1 = {6, 3, 6};
        int result1 = solution.specialTriplets(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [6,3,6]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 1");
        System.out.println();

        // 测试用例2
        int[] nums2 = {8, 4, 2, 8, 4};
        int result2 = solution.specialTriplets(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [8,4,2,8,4]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 2");
        System.out.println();

        // 测试用例2
        int[] nums3 = {0, 1, 0, 0};
        int result3 = solution.specialTriplets(nums3);
        System.out.println("测试用例3:");
        System.out.println("输入: nums = [0,1,0,0]");
        System.out.println("输出: " + result3);
        System.out.println("期望: 1");
        System.out.println();
    }

}