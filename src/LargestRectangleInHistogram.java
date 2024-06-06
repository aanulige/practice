public class LargestRectangleInHistogram {
    public static int MAXN = 100001;
    public static int[] stack = new int[MAXN];
    public static int r;
    public int largestRectangleInHistogram(int[] height){
        int n = height.length;
        r = 0;
        int ans = 0, cur, left;
        for (int i = 0; i < n; i++) {
            while (r > 0 && height[i] <= height[stack[r - 1]]){
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, (i - left - 1) * height[cur]);
            }
            stack[r++] = i;
        }
        while(r > 0){
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, (n - left - 1) * height[cur]);
        }
        return ans;
    }
}
