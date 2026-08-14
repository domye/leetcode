package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 轻量测试辅助类。每题在 main 里直接 T.eq(期望, 实际, "用例名") 断言，跑完调 T.summary()。
 * 仅供单线程测试场景使用，无并发。
 */
public final class T {
    private T() {}

    private static int passed = 0;
    private static int failed = 0;

    public static void eq(int expected, int actual, String name) {
        check(expected == actual, name, "期望 " + expected + "，实际 " + actual);
    }

    public static void eq(long expected, long actual, String name) {
        check(expected == actual, name, "期望 " + expected + "，实际 " + actual);
    }

    /** 浮点比较，允许误差 eps。 */
    public static void eq(double expected, double actual, double eps, String name) {
        check(Math.abs(expected - actual) <= eps, name, "期望 " + expected + "，实际 " + actual);
    }

    public static void eq(int[] expected, int[] actual, String name) {
        check(Arrays.equals(expected, actual), name,
                "期望 " + Arrays.toString(expected) + "，实际 " + Arrays.toString(actual));
    }

    public static void eq(int[][] expected, int[][] actual, String name) {
        check(Arrays.deepEquals(expected, actual), name,
                "期望 " + Arrays.deepToString(expected) + "，实际 " + Arrays.deepToString(actual));
    }

    public static void eq(String expected, String actual, String name) {
        check(expected.equals(actual), name, "期望 " + expected + "，实际 " + actual);
    }

    public static void eq(List<?> expected, List<?> actual, String name) {
        check(expected.equals(actual), name, "期望 " + expected + "，实际 " + actual);
    }

    /** 外层与内层均不要求顺序（如字母异位词分组）。 */
    public static void eqSet(List<List<String>> expected, List<List<String>> actual, String name) {
        check(setOf(expected).equals(setOf(actual)), name, "期望 " + expected + "，实际 " + actual);
    }

    /** 打印汇总；有失败则退出码 1，方便批量跑题。 */
    public static void summary() {
        System.out.printf("通过 %d，失败 %d%n", passed, failed);
        if (failed > 0) System.exit(1);
    }

    private static Set<String> setOf(List<List<String>> lists) {
        Set<String> set = new HashSet<>();
        for (List<String> list : lists) {
            List<String> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            set.add(sorted.toString());
        }
        return set;
    }

    private static void check(boolean ok, String name, String detail) {
        if (ok) {
            passed++;
            System.out.println("PASS " + name + " —— " + detail);
        } else {
            failed++;
            System.out.println("FAIL " + name + " —— " + detail);
        }
    }
}
