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
    
    private int mind = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)return 1;
        check(root.left, 1);
        check(root.right, 1);
        
        return mind;
    }
    
    private void check(TreeNode r, int d) {
        if(r == null) {
            //if(d<mind) mind = d;
            return;
        }
        d++;
        if(r.left == null && r.right == null) {
            if(d<mind) mind = d;
            return;
        }else{
            check(r.left, d);
            check(r.right, d);
        }
    }
}