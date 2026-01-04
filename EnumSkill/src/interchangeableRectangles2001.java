import java.util.HashMap;

public class interchangeableRectangles2001 {
//    用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
//
//    如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
//
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
        interchangeableRectangles2001 solution = new interchangeableRectangles2001();

        // 测试用例1
        int[][] nums1 = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        long result1 = solution.interchangeableRectangles(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [[4,8],[3,6],[10,20],[15,30]]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 6");
        System.out.println();

        // 测试用例2
        int[][] nums2 = {{4, 5}, {7, 8}};
        long result2 = solution.interchangeableRectangles(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [[4,5],[7,8]]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 0");
        System.out.println();


    }

}