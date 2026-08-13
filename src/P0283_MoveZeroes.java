public class P0283_MoveZeroes {
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
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        T.eq(new int[]{1, 3, 12, 0, 0}, nums1, "示例1 原地修改");

        int[] nums2 = {0, 0, 1, 0, 2, 0, 3};
        moveZeroes(nums2);
        T.eq(new int[]{1, 2, 3, 0, 0, 0, 0}, nums2, "示例2 原地修改");

        int[] nums3 = {1, 2, 3, 0, 0};
        moveZeroes(nums3);
        T.eq(new int[]{1, 2, 3, 0, 0}, nums3, "示例3 原地修改");
        T.summary();
    }
}
