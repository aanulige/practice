//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSubArray(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if(dp[i - 1] <= 0){
                dp[i] = nums[i];
            }else{
                dp[i] = nums[i] + dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
