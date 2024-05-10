import java.util.Arrays;

public class Fibonacci {
    //暴力递归
    public static int fib1(int n){
        return f1(n);
    }

    public static int f1(int i){
        if(i == 0) return 0;
        if(i == 1) return 1;
        return f1(i - 1) + f1(i - 2);
    }

    //记忆化搜索
    public static int fib2(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f2(n, dp);
    }

    public static int f2(int i, int[] dp){
        if(i == 0) return 0;
        if(i == 1) return 1;
        if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = f2(i - 1, dp) + f2(i - 2, dp);
        return dp[i];
    }

    //位置依赖dp
    public static int fib3(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int a = fib1(7);
        int b = fib2(7);
        int c = fib3(7);
        System.out.print(a + " " + b + " " + c);
    }
}
