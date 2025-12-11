import java.util.Arrays;

public class maxFreeTime3439 {
//    给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
//    同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
//    你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
//    移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
//    请你返回重新安排会议以后，可以得到的 最大 空余时间。
//    注意，会议 不能 安排到整个活动的时间以外。

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
//    首先，求出来每个会议的间隔时间，因为第一个会议有可能在t=0后开始，比如说他在t=2时开始
//    那么它实际上在这个会议前，有一个2的间隔
        int length = startTime.length;
        int[] space = new int[length + 1];
        space[0] = startTime[0];
        for (int i = 1; i < length; i++)
            space[i] = startTime[i] - endTime[i - 1];
        space[length] = eventTime - endTime[length - 1];
        // 套定长滑窗模板（窗口长为 k+1）
        int ans = 0;
        int s = 0;
        for (int i = 0; i <= length; i++) {
            s += space[i];
            if (i < k) {
                continue;
            }
            ans = Math.max(ans, s);
            s -= space[i - k];
        }
        return ans;
    }


    public static void main(String[] args) {
        maxFreeTime3439 solution = new maxFreeTime3439();

        // 测试用例1
        int eventTime1 = 5;
        int k1 = 1;
        int[] startTime1 = {1, 3};
        int[] endTime1 = {2, 5};
        int result1 = solution.maxFreeTime(eventTime1, k1, startTime1, endTime1);
        System.out.println("测试用例1:");
        System.out.println("输入: eventTime = " + eventTime1 + ", k = " + k1);
        System.out.println("startTime = " + Arrays.toString(startTime1));
        System.out.println("endTime = " + Arrays.toString(endTime1));
        System.out.println("输出: " + result1);
        System.out.println("期望: 2");
        System.out.println();

        // 测试用例2
        int eventTime2 = 10;
        int k2 = 1;
        int[] startTime2 = {0, 2, 9};
        int[] endTime2 = {1, 4, 10};
        int result2 = solution.maxFreeTime(eventTime2, k2, startTime2, endTime2);
        System.out.println("测试用例2:");
        System.out.println("输入: eventTime = " + eventTime2 + ", k = " + k2);
        System.out.println("startTime = " + Arrays.toString(startTime2));
        System.out.println("endTime = " + Arrays.toString(endTime2));
        System.out.println("输出: " + result2);
        System.out.println("期望: 6");
        System.out.println();

        // 测试用例3
        int eventTime3 = 5;
        int k3 = 2;
        int[] startTime3 = {0, 1, 2, 3, 4};
        int[] endTime3 = {1, 2, 3, 4, 5};
        int result3 = solution.maxFreeTime(eventTime3, k3, startTime3, endTime3);
        System.out.println("测试用例3:");
        System.out.println("输入: eventTime = " + eventTime3 + ", k = " + k3);
        System.out.println("startTime = " + Arrays.toString(startTime3));
        System.out.println("endTime = " + Arrays.toString(endTime3));
        System.out.println("输出: " + result3);
        System.out.println("期望: 0");
    }
}