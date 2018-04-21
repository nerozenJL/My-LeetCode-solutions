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
    //private int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        //层次遍历
        Integer min = Integer.MAX_VALUE, smin = null;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n.val <= min) {
                min = n.val;
            }else if(smin != null) {
                if(n.val < smin) smin = n.val;
            }else {
                smin = n.val;
            }
            if(n.left != null)q.offer(n.left);
            if(n.right != null)q.offer(n.right);
        }
        return (smin == null)?-1:smin;
    }    
}