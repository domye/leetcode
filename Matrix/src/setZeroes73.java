public class setZeroes73 {
    public void setZeroesBF(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] col = new boolean[m + 1];
        boolean[] row = new boolean[n + 1];
        //看到这道题的第一想法，就是先找出有哪些位置为0
        //然后遍历这些，将其改为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;

                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[j] || col[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] col = new boolean[m + 1];
        boolean[] row = new boolean[n + 1];
        //看到这道题的第一想法，就是先找出有哪些位置为0
        //然后遍历这些，将其改为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;

                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[j] || col[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        setZeroes73 solution = new setZeroes73();

        // 测试用例1
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("测试用例1:");
        System.out.println("输入:");
        printMatrix(matrix1);
        solution.setZeroes(matrix1);
        System.out.println("输出:");
        printMatrix(matrix1);

        // 测试用例2
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("\n测试用例2:");
        System.out.println("输入:");
        printMatrix(matrix2);
        solution.setZeroes(matrix2);
        System.out.println("输出:");
        printMatrix(matrix2);
    }

    // 辅助方法：打印矩阵
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
