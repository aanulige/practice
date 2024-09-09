public class PalindromicSubstrings {
    public int countSubstrings(String s){
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
