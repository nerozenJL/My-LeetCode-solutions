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
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root != null) {
            int len = calculate(root.left, root.val) + calculate(root.right, root.val);
            if(len>max)max = len;
            longestUnivaluePath(root.left);
            longestUnivaluePath(root.right);
        }
        return max;
    }
    private int calculate(TreeNode t, int pval) {
        if(t==null) return 0;
        if(t.val == pval) return Math.max(calculate(t.left, pval), calculate(t.right, pval)) + 1;
        else return 0;
    }
}