import java.util.HashSet;
import java.util.Set;

public class NumDistinctIslands {
    private static int m;
    private static int n;
    private static StringBuilder path = new StringBuilder();

    public static int numDistinctIsland(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    dfs(grid, i, j, 0);
                    set.add(path.toString());
                    path.setLength(0);
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] grid, int i, int j, int k) {
        grid[i][j] = 0;
        path.append(k);
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int l = 1; l < 5; ++l) {
            int x = i + dirs[l - 1];
            int y = j + dirs[l];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                dfs(grid, x, y, l);
            }
        }
        //path.append(k);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1}, {1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        int ans = numDistinctIsland(grid);
        System.out.print(ans);
    }
}
