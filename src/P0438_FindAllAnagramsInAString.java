import common.*;
import java.util.ArrayList;
import common.*;
import java.util.Arrays;
import common.*;
import java.util.List;

public class P0438_FindAllAnagramsInAString {
    //    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    public List<Integer> findAnagrams(String s, String p) {
        //这题很明显是滑动窗口，我觉得重点就是如何判断是否是异位词
        //用数组来存词，左坐标向右滑，减少左边的，右坐标向右
        int pl = p.length();
        int sl = s.length();

        if (pl > sl)
            return new ArrayList<>();

        int[] a = new int[26];
        for (char c : p.toCharArray()) {
            a[c - 'a']++; // 统计 p 的字母
        }

        List<Integer> ans = new ArrayList<>();

        int[] b = new int[26]; // 统计 s 的长为 p.length() 的子串 t 的每种字母的出现次数
        for (int i = 0; i < pl; i++) {
            b[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= sl - pl; i++) {
            if (Arrays.equals(a, b)) { // t 和 p 的每种字母的出现次数都相同
                ans.add(i);
            }
            b[s.charAt(i) - 'a']--; // 左端点字母离开窗口
            if (i + pl < sl)
                b[s.charAt(i + pl) - 'a']++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P0438_FindAllAnagramsInAString solution = new P0438_FindAllAnagramsInAString();
        T.eq(List.of(0, 6), solution.findAnagrams("cbaebabacd", "abc"), "示例1");
        T.eq(List.of(0, 1, 2), solution.findAnagrams("abab", "ab"), "示例2");
        T.summary();
    }
}
