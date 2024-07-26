public class MinimumPathSum {
    //暴力递归
    //https://leetcode.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        return f1(grid, grid.length - 1, grid[0].length - 1);
    }

    public static int f1(int[][] grid, int i, int j){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i - 1 >= 0){
            up = f1(grid, i - 1, j);
        }
        if(j - 1 >= 0){
            left = f1(grid, i , j - 1);
        }
        return grid[i][j] + Math.min(up, left);
    }

    //记忆化搜索
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(grid,0,0, dp);
    }

    public static int f2(int[][] grid, int i, int j, int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans;
        if(i == 0 && j == 0) {
            ans = grid[i][j];
        } else {
            int up = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            if(i - 1 >= 0){
                up = f2(grid, i - 1, j, dp);
            }
            if(j - 1 >= 0) {
                left = f2(grid, i, j - 1, dp);
            }
            ans = grid[i][j] + Math.min(up, left);
        }
        dp[i][j] = ans;
        return ans;
    }

    //位置依赖
    public int minPathSum3(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
