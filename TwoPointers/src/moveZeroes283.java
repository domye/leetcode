public class moveZeroes283 {
    //这题需要将数组中的所有零放到最后
    // 类似于滑动窗口的算法
    // 一个左指针一个右指针
    //遍历的时候，如果该数不为0，那么移动左右指针到下一个
    //当为0的时候，左指针不动，右指针继续遍历，直到找到一个不为0的数
    //替换左右指针的数值
    public static void moveZeroes(int[] nums) {

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (right != left) {
                    nums[left] = nums[right];
                    nums[right] = 0;

                }
                left++;
            }
        }


    }

    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("测试用例1:");
        System.out.println("输入: [0, 1, 0, 3, 12]");
        moveZeroes(nums1);
        System.out.print("输出: [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
            if (i < nums1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        // 测试用例2
        int[] nums2 = {0, 0, 1, 0, 2, 0, 3};
        System.out.println("测试用例2:");
        System.out.println("输入: [0, 0, 1, 0, 2, 0, 3]");
        moveZeroes(nums2);
        System.out.print("输出: [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            if (i < nums2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        // 测试用例3
        int[] nums3 = {1, 2, 3, 0, 0};
        System.out.println("测试用例3:");
        System.out.println("输入: [1, 2, 3, 0, 0]");
        moveZeroes(nums3);
        System.out.print("输出: [");
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]);
            if (i < nums3.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
