import common.*;
import java.util.ArrayList;
import common.*;
import java.util.Arrays;
import common.*;
import java.util.List;

public class P0056_MergeIntervals {
    //    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        P0056_MergeIntervals solution = new P0056_MergeIntervals();
        T.eq(new int[][]{{1, 6}, {8, 10}, {15, 18}},
                solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}), "示例1");
        T.summary();
    }
}
