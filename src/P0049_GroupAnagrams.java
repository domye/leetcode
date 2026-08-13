import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
public class P0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String skey = new String(strChar);
            List<String> e = strMap.getOrDefault(skey, new ArrayList<>());
            e.add(str);
            strMap.put(skey, e);
        }
        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        P0049_GroupAnagrams solution = new P0049_GroupAnagrams();
        T.eqSet(List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")),
                solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), "示例1");
        T.eqSet(List.of(List.of("a")), solution.groupAnagrams(new String[]{"a"}), "示例2");
        T.summary();
    }
}
