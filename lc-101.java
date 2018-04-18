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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }
    private boolean check(TreeNode r1, TreeNode r2) {
        if(r1!=null && r2!=null) {
            if(r1.val==r2.val) {
                return check(r1.left, r2.right) && check(r1.right, r2.left);
            }else {
                return false;
            }
        }else if(r1 == null && r2 == null){
            return true;
        }else return false;
    }
}