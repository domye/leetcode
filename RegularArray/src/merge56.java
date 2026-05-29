package middle;

import java.util.HashMap;

public class numPairsDivisible1010 {
    //    在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
//
//    返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
    public int numPairsDivisibleBy60(int[] time) {

        //如果两个数相加为60整除，那a被60除后的余数+b被60除后的余数除以60的余数为0
        //即（a%60+b%60）%60=0
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            count +=map.getOrDefault((60 - i % 60) % 60,0);
            map.put(i%60,map.getOrDefault(i%60,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        numPairsDivisible1010 solution = new numPairsDivisible1010();

        // 测试用例1
        int[] nums1 = {30, 20, 150, 100, 40};
        int m1 = 1;
        int result1 = solution.numPairsDivisibleBy60(nums1);
        System.out.println("测试用例1:");
        System.out.println("输入: nums = [30,20,150,100,40]");
        System.out.println("输出: " + result1);
        System.out.println("期望: 3");
        System.out.println();

        // 测试用例2
        int[] nums2 = {60, 60, 60};
        int m2 = 3;
        int result2 = solution.numPairsDivisibleBy60(nums2);
        System.out.println("测试用例2:");
        System.out.println("输入: nums = [60,60,60]");
        System.out.println("输出: " + result2);
        System.out.println("期望: 3");
        System.out.println();
    }
}
