public   class LongestCommonSubseq {
    public static int longestCommonSubsequence(String a, String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int n = s1.length - 1;
        int m = s2.length - 1;
        return f1(s1, s2, n, m);
    }

    private static int f1(char[] s1, char[] s2, int n, int m) {
        if(n < 0 || m < 0){
            return 0;
        }
        int p1 = f1(s1, s2, n - 1, m - 1);
        int p2 = f1(s1, s2, n - 1, m );
        int p3 = f1(s1, s2, n , m - 1);
        int p4 = s1[n] == s2[m] ? (p1 + 1) : 0;
        return Math.max(Math.max(p1,p2), Math.max(p3,p4));
    }


    public static int longestCommonSubsequence2(String a, String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int n = s1.length;
        int m = s2.length;
        return f2(s1, s2, n, m);
    }
    public static int f2(char[] s1, char[] s2, int len1, int len2){
        if(len1 == 0 || len2 == 0) return 0;
        int ans;
        if(s1[len1 - 1] == s2[len2 - 1]){
            ans = f2(s1, s2, len1 - 1, len2 - 1) + 1;
        } else{
            ans = Math.max(f2(s1, s2, len1 - 1, len2), f2(s1, s2, len1, len2 - 1));
        }
        return ans;
    }

    public static int longestCommonSubsequence3(String a, String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int len1 = 1; len1 <= n; len1++) {
            for (int len2  = 1; len2 <= n; len2++){
                if(s1[len1 - 1] == s2[len2 - 1]){
                    dp[len1][len2] = dp[len1 - 1][len2 - 1] + 1;
                }else{
                    dp[len1][len2] = Math.max(dp[len1 - 1][len2], dp[len1][len2 - 1]);
                }
            }
        }
        return dp[n][m];
    }


}
