public class MergeSort {
    public static int MAXN = 100001;
    
    public int[] help = new int[MAXN];
    public int[] mergeSort(int[] nums){
        if(nums.length > 1){
            sort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if(l  == r){
            return;
        }
        int m = (l + r) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r){
        int i = l;
        int a = l;
        int b = m + 1;
        while(a <= m && b <= r){
            help[i++] = nums[a] <= nums[b] ? nums[a] : nums[b];
        }
        while(a <= m){
            help[i++] = nums[a++];
        }
        while(b <= m){
            help[i++] = nums[b++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = help[i];
        }

    }


}
