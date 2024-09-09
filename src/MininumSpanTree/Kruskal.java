package MininumSpanTree;

import java.io.*;
import java.util.Arrays;

public class Kruskal {
    public static int MAXN = 5001;

    public static int MAXM = 200001;

    public static int[] parent = new int[MAXN];

    // u, v, w
    public static int[][] edges = new int[MAXM][3];

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            build();
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[i][0] = (int) in.nval;
                in.nextToken();
                edges[i][1] = (int) in.nval;
                in.nextToken();
                edges[i][2] = (int) in.nval;
            }
            Arrays.sort(edges, 0, m, (a, b) -> a[2] - b[2]);
            int ans = 0;
            int edgeCnt = 0;
            for (int[] edge : edges) {
                if(union(edge[0], edge[1])){
                    edgeCnt++;
                    ans += edge[2];
                }
            }
            out.println(edgeCnt == n - 1 ? ans : "orz");
        }
        out.flush();
        out.close();
        br.close();
    }

    private static void build() {
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    private static int find(int i){
        if(i != parent[i]){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private static boolean union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            parent[fx] = fy;
            return true;
        } else {
            return false;
        }
    }
}
