import java.util.HashMap;

public class P2001_InterchangeableRectangles {
    //    用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
    //    如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
    //    计算并返回 rectangles 中有多少对 可互换 矩形。
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            double a = rectangle[0] * 1.0 / rectangle[1];
            count += map.getOrDefault(a, 0);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        P2001_InterchangeableRectangles solution = new P2001_InterchangeableRectangles();
        T.eq(6L, solution.interchangeableRectangles(
                new int[][]{{4, 8}, {3, 6}, {10, 20}, {15, 30}}), "示例1");
        T.eq(0L, solution.interchangeableRectangles(
                new int[][]{{4, 5}, {7, 8}}), "示例2");
        T.summary();
    }
}
