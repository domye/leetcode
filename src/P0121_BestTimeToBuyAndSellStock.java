import common.*;

public class P0121_BestTimeToBuyAndSellStock {
    //    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;
        for (int price : prices) {
            result = Math.max(result, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return result;
    }

    public static void main(String[] args) {
        P0121_BestTimeToBuyAndSellStock solution = new P0121_BestTimeToBuyAndSellStock();
        T.eq(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), "示例1");
        T.eq(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}), "示例2");
        T.summary();
    }
}
