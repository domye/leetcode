import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
public class groupAnagrams49 {
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
        groupAnagrams49 solution = new groupAnagrams49();

        // 测试示例1
        String[] strings1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strings1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]");
        System.out.println("输出: " + result1);
        System.out.println("期望: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");
        System.out.println();
        // 测试示例2
        String[] strings2 = {"a"};
        List<List<String>> result2 = solution.groupAnagrams(strings2);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [\"a\"]");
        System.out.println("输出: " + result2);
        System.out.println("期望: [[\"a\"]]");
        System.out.println();
    }
}
