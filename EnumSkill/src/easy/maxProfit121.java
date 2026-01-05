package easy;

public class maxProfit121 {
//    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;
        for (int price : prices) {
            result=Math.max(result,price-minPrice);
            minPrice=Math.min(price,minPrice);
        }
        return result;
    }

    public static void main(String[] args) {
        maxProfit121 solution = new maxProfit121();

        // 测试用例1
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [7,1,5,3,6,4]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 5");
        System.out.println();

        // 测试用例2
        int[] nums2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [7,6,4,3,1]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 0");
        System.out.println();
    }

}