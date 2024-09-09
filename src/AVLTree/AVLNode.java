package AVLTree;

import Tree.TreeNode;

public class AVLNode extends TreeNode {
    int height;
    int key;
    AVLNode left;
    AVLNode right;

    AVLNode(int key){
        super(key);
        this.key = key;
        this.height = 1;
    }

    AVLNode(int key, AVLNode left, AVLNode right) {
        super(key, left, right);  // 调用父类的构造函数，将 key 赋值给 val
        this.key = key;  // 在 Node 中使用 key
        this.height = 1;
        this.left = left;
        this.right = right;
    }
}
