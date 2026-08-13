public class P0189_RotateArray {
    public int rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return k;
        }

        int n = nums.length;
        k = k % n; // 处理 k > n 的情况
        int[] rotated = new int[n]; // 新数组

        // 遍历 n 次，按你的思路填充新数组
        for (int i = 0; i < n; i++) {
            if (i < k) {
                // 前 k 个位置放原数组的后 k 个元素
                rotated[i] = nums[n - k + i];
            } else {
                // 剩下的位置放原数组的前 n - k 个元素
                rotated[i] = nums[i - k];
            }
        }

        // 把 rotated 复制回原数组（题目要求修改原数组）
        System.arraycopy(rotated, 0, nums, 0, n);
        return k;
    }

    public static void main(String[] args) {
        P0189_RotateArray solution = new P0189_RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        T.eq(new int[]{5, 6, 7, 1, 2, 3, 4}, nums, "示例1 原地修改");
        T.summary();
    }
}
