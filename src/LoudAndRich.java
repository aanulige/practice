import java.util.ArrayList;
import java.util.Queue;

//https://leetcode.com/problems/loud-and-rich/
//Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//Output: ans = [5,5,2,5,4,5,6,7]
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet){
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int[] r: richer) {
            graph.get(r[0]).add(r[1]);
            inDegree[r[1]]++;
        }

        int queue[] = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0){
                queue[r++] = i;
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        while(l < r){
            int cur = queue[l++];
            for (int next : graph.get(cur)) {
                if(quiet[ans[cur]] < quiet[ans[next]]){
                    ans[next] = ans[cur];
                }
                if(--inDegree[next] == 0){
                    queue[r++] = next;
                }
            }

        }

        return ans;
    }

}
