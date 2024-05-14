public class numIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i , j);
                }
            }
        }
        return islands;
    }

    public static void bfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 0;
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i , j + 1);
        bfs(grid, i , j - 1);
    }
}
