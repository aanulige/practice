package Tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class PreOderTraversal {
    public List<Integer> preoderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursiveMethod(root, res);
        return res;
    }

    private void recursiveMethod(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        recursiveMethod(root.left, list);
        recursiveMethod(root.right, list);
    }

    public void loopMethod(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(stack.isEmpty() || cur != null){
            if(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
    }

}
