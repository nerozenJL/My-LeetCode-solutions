/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return root;
        pruneTree(root.left);
        pruneTree(root.right);
        if(needToDelete(root.left)) root.left = null;
        if(needToDelete(root.right)) root.right = null;
        return root;
    }
    private boolean needToDelete(TreeNode n) {
        if(n == null) return true;
        if(n.val == 1) return false;
        if(n.right == null && n.left == null) {
            if(n.val == 1) return false;
            else return true;
        }
        return needToDelete(n.left) && needToDelete(n.right);
    }
    
    //要删除的结点
    //为0的叶子结点
    //全为0的子树
}