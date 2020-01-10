package test;

public class constructBinaryTreeFromPreorderAndInorderTraversal105 {
    // 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(char[] preorder, char[] inorder) {
        return build(preorder, inorder, '0');
    }

    private TreeNode build(char[] preorder, char[] inorder, char stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        constructBinaryTreeFromPreorderAndInorderTraversal105 test = new constructBinaryTreeFromPreorderAndInorderTraversal105();
// 先序遍历: EFHIGJK 中序遍历: HFIEJKG
        TreeNode tree = test.buildTree(new char[]{'E', 'F', 'H', 'I', 'G', 'J', 'K'}, new char[]{'H', 'F', 'I', 'E', 'J', 'K', 'G'});
        System.out.println(tree);
    }
}
