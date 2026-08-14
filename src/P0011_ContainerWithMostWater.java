import common.*;

public class P0011_ContainerWithMostWater {
    //    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //    返回容器可以储存的最大水量。
    //    说明：你不能倾斜容器。
    public int maxArea(int[] height) {
        int n = height.length - 1;
        int a = 0;
        int b = n;
        int max = Integer.MIN_VALUE;
        while (a < b) {
            if (height[a] < height[b]) {
                int s = n * height[a];
                max = Math.max(s, max);
                a++;
            } else {
                int s = n * height[b];
                max = Math.max(s, max);
                b--;
            }
            n--;
        }
        return max;
    }

    public static void main(String[] args) {
        P0011_ContainerWithMostWater solution = new P0011_ContainerWithMostWater();
        T.eq(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), "示例1");
        T.eq(1, solution.maxArea(new int[]{1, 1}), "示例2");
        T.summary();
    }
}
