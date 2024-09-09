package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal {

    public static List<Integer> inOderTraverse(TreeNode root){
        List<Integer> res = new ArrayList<>();
        loopMethod(root, res);
        return res;
    }

    private static void recursiveMethod(TreeNode root, List<Integer> res) {
        if(root == null) return;
        recursiveMethod(root.left,res);
        res.add(root.val);
        recursiveMethod(root.right,res);
    }

    private static void loopMethod(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;    // 设置根节点的左子节点
        root.right = node2;   // 设置根节点的右子节点
        node1.left = node3;   // 设置第二层左节点的左子节点
        node1.right = node4;  // 设置第二层左节点的右子节点
        node2.right = node5;  // 设置第二层右节点的右子节点
        List<Integer> list = inOderTraverse(root);
        for(int num:list){
            System.out.print(num + " ");
        }


    }
}
