import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


// The number of binary trees with n nodes and height not greater than m.
// there are n nodes, calculate how many binary trees with different structures there are
// Solutions that satisfy the requirement that the number of nodes is n and the height of the tree does not exceed m
// Because the answer is very large, the answer needs to be modulo 1000000007 and then output
public class NodeNHeightNotLargerThanM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            out.println(compute2(n, m));
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int MAXN = 51;

    public static int MOD = 1000000007;

    public static int[][] dp = new int[MAXN][MAXN];

    private static int compute2(int n, int m) {
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 0;
                for (int k = 0; k < i; k++) {
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % MOD) %MOD;
                }
            }
        }
        return dp[n][m];
    }
}
