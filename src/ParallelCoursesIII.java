import java.util.ArrayList;

public class ParallelCoursesIII {
    //https://leetcode.com/problems/parallel-courses-iii/description/
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] edge : relations){
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0){
                queue[r++] = i;
            }
        }
        int[] cost = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = 0;
        }
        while(l < r){
            int cur = queue[l++];
            cost[cur] += time[cur - 1];
            ans = Math.max(ans, cost[cur]);

            for(int next : graph.get(cur)){
                cost[next] = Math.max(cost[next], cost[cur]);
                if(--inDegree[next] == 0){
                    queue[r++] = next;
                }
            }
        }
        return ans;
    }
}
