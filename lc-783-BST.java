/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//非常重要的思路：BST(二叉搜索树，中序遍历就是一个有序序列)

class Solution {
    
    private Integer mindiff = Integer.MAX_VALUE;
    private Integer pre = null;
    
    public int minDiffInBST(TreeNode root) {
        pre(root);
        return mindiff;
    }
    
    public void pre(TreeNode root) {
        if(root==null)return;//开始回溯
        pre(root.left);
        if(pre != null)
            mindiff = Math.min(mindiff, Math.abs(root.val - pre));
        pre = root.val;
        pre(root.right);
        
    }
}