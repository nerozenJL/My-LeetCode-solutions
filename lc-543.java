/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 非常适合做算法复杂度的分析，以及后续的优化，毕竟重复遍历的地方太多了
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int d= calculateMaxDepth(root.left) + calculateMaxDepth(root.right); //这个是计算左右子树"最大半径"之和(每个结点都抛弃了一颗子树的信息)
        int ld = diameterOfBinaryTree(root.left); //保留了子树的信息
        int rd = diameterOfBinaryTree(root.right);
        return Math.max(d, Math.max(ld, rd));
    }
    private int calculateMaxDepth(TreeNode t) {
        return t == null?0:(Math.max(calculateMaxDepth(t.left),calculateMaxDepth(t.right)) + 1);
    }
}