import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        f1(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void f1(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        if(index == nums.length){
            ans.add(cur);
        }
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            f1(nums, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }


}
