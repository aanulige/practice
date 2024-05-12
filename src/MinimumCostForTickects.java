import java.util.Arrays;

public class MinimumCostForTickects {
    //You have planned some train traveling one year in advance. The days of the year in which you will
    // travel are given as an integer array days. Each day is an integer from 1 to 365.
    //
    //Train tickets are sold in three different ways:
    //
    //a 1-day pass is sold for costs[0] dollars,
    //a 7-day pass is sold for costs[1] dollars, and
    //a 30-day pass is sold for costs[2] dollars.
    //The passes allow that many days of consecutive travel.
    //
    //For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
    //Return the minimum number of dollars you need to travel every day in the given list of days
    //Example 1:
    //
    //Input: days = [1,4,6,7,8,20], costs = [2,7,15]
    //Output: 11

    public static int[] duration = {1, 7, 30};

    //Recursion
    public int minCostTickets(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    //days[i... What is the minimum cost????
    public static int f1(int[] days, int[] costs, int i){
        if(i == days.length) return 0;
        // i: the ith day
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < costs.length; k++) {
            while(j < days.length && days[i] + duration[k] > days[j]){
                // The longest plan is cost[2], which is 30 days
                // so, for this while loop the time complexity  is O(1)
                j++;
            }
            ans = Math.min(ans, costs[k] + f1(days, costs, j));
        }
        return ans;
    }
    //Memoization Search
    public int minCostTickets2(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return f2(days, costs, 0, dp);
    }

    public static int f2(int[] days, int[] costs, int i, int[] dp){
        if(i == days.length) return 0;
        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }
        for (int k = 0, j = i; k < 3; k++) {
            while(j < days.length && days[i] + duration[k] > days[j]){
                j++;
            }
            dp[i] = Math.min(dp[i], costs[k] + f2(days, costs, j, dp));
        }
        return dp[i];
    }

    
    /* Dynamic Programing */
    
    public static int MAXN = 366;
    public int minCostTickets3(int[] days, int[] costs){
        int n = days.length;
        int[] dp = new int[MAXN];
        Arrays.fill(dp, 0, n + 1, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < 3; k++) {
                while (j < days.length && days[i] + duration[k] > days[j]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], costs[k] + dp[j]);
            }    
        }
        return dp[0];
    }

}
