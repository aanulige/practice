public class LongestPalindromicSubseq {
    public int longestPalindromeSubseq(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int dp[][] = new int[n][n];
        for(int l = n - 1; l >= 0; l--){
            dp[l][l] = 1;
            if(l + 1 < n){
                dp[l][l+1] = s[l] == s[l + 1] ? 2 : 1;
            }
            for(int r = l + 2; r < n; r++){
               if(s[l] == s[r]){
                   dp[l][r] = 2 + dp[l + 1][r - 1];
               } else{
                   dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
               }
            }
        }
        return dp[0][n-1];
    }
}
