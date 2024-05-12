import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    /**
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets
     * (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * Example 1:
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, ans, 0, new int[nums.length], 0);
        return ans;
    }

    public static void f(int[] nums, List<List<Integer>> ans, int i, int[] path, int size){
        if(i == nums.length){
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
        } else{
            int j = i + 1;
            while(j < nums.length && nums[j] == nums[i]){
                j++;
            }
            f(nums, ans, j, path, size);
            while(i < j){
                path[size++] = nums[i];
                f(nums, ans, j, path, size);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,5};
        List<List<Integer>> ans = new ArrayList<>();
        ans = subsetsWithDup(nums);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
