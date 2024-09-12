import java.util.Arrays;

public class OptimizeWaterDistributionInAVillage {
    //https://leetcode.com/problems/optimize-water-distribution-in-a-village/description/
    // 水资源分配优化
    // 村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
    // 对于每个房子 i，我们有两种可选的供水方案：一种是直接在房子内建造水井
    // 成本为 wells[i - 1] （注意 -1 ，因为 索引从0开始 ）
    // 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，
    // 其中每个 pipes[j] = [house1j, house2j, costj]
    // 代表用管道将 house1j 和 house2j连接在一起的成本。连接是双向的。
    // 请返回 为所有房子都供水的最低总成本
    // 测试链接 : https://leetcode.cn/problems/optimize-water-distribution-in-a-village/

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes){
        build(n);
        for (int i = 0; i < n; i++, cnt++) {
            edges[cnt][0] = 0;
            edges[cnt][1] = i + 1;
            edges[cnt][2] = wells[i];
        }

        for (int i = 0; i < pipes.length; i++, cnt++) {
            edges[cnt][0] = pipes[i][0];
            edges[cnt][1] = pipes[i][1];
            edges[cnt][2] = pipes[i][2];
        }

        Arrays.sort(edges, 0, cnt, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for(int i = 0; i < cnt; i++){
            if(union(edges[i][0], edges[i][1])){
                ans += edges[i][2];
            }
        }
        return ans;
    }

    private static final int MAXN = 10010;
    private static int[][] edges = new int[MAXN << 1][3];
    public static int cnt;
    public static int[] parent = new int[MAXN];

    private static void build(int n){
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private static int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private static boolean union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            parent[fa] = fb;
            return true;
        }else {
            return false;
        }
    }
}
