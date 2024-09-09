package AVLTree;

import Tree.TreeNode;
import AVLTree.AVLNode;
import com.sun.source.tree.Tree;

public class AVLTree {
    AVLNode root;

    int height(TreeNode N){
        if(N == null) return 0;
        return ((AVLNode) N).height;
    }

    int balanceFactor(AVLNode N){
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    AVLNode rightRotate(AVLNode node){
        AVLNode child = node.left;
        AVLNode grandChild = child.right;
        child.right = node;
        node.left = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    AVLNode leftRotate(AVLNode node){
        AVLNode child = node.right;
        AVLNode grandChild = child.left;
        child.left = node;
        node.right = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    AVLNode rotate(AVLNode node) {
        // 获取节点 node 的平衡因子
        int balanceFactor = balanceFactor(node);
        // 左偏树
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // 右旋
                return rightRotate(node);
            } else {
                // 先左旋后右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // 右偏树
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                // 左旋
                return leftRotate(node);
            } else {
                // 先右旋后左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // 平衡树，无须旋转，直接返回
        return node;
    }

    void insert(int val){
        root = insertHelper(root, val);
    }

    private AVLNode insertHelper(AVLNode node, int val) {
        if (node == null)
            return new AVLNode(val);
        /* 1. 查找插入位置并插入节点 */
        if (val < node.key)
            node.left = insertHelper(node.left, val);
        else if (val > node.key)
            node.right = insertHelper(node.right, val);
        else
            return node; // 重复节点不插入，直接返回
        updateHeight(node); // 更新节点高度
        /* 2. 执行旋转操作，使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }

    void remove(int val) {
        root = removeHelper(root, val);
    }

    /* 递归删除节点（辅助方法） */
    AVLNode removeHelper(AVLNode node, int val) {
        if (node == null)
            return null;
        /* 1. 查找节点并删除 */
        if (val < node.key)
            node.left = removeHelper(node.left, val);
        else if (val > node.key)
            node.right = removeHelper(node.right, val);
        else {
            if (node.left == null || node.right == null) {
                AVLNode child = node.left != null ? node.left : node.right;
                // 子节点数量 = 0 ，直接删除 node 并返回
                if (child == null)
                    return null;
                    // 子节点数量 = 1 ，直接删除 node
                else
                    node = child;
            } else {
                // 子节点数量 = 2 ，则将中序遍历的下个节点删除，并用该节点替换当前节点
                AVLNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.key);
                node.key = temp.key;
            }
        }
        updateHeight(node); // 更新节点高度
        /* 2. 执行旋转操作，使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }
}
