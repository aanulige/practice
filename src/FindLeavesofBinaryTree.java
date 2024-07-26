import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> res = new ArrayList<>();
    public int dfs(TreeNode root){
        if(root == null) return -1;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int curLevel = Math.max(l, r) + 1;
        while(res.size() < curLevel){
            res.add(new ArrayList<>());
        }
        res.get(curLevel).add(root.val);
        return curLevel;
    }
    public List<List<Integer>> findLeaves(TreeNode root){
        dfs(root);
        return res;
    }

}
