/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*

遍历整棵树，到叶子结点就把路径字符串加入到结果集中

*/


class Solution {
    private List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null)updatePath(root, Integer.toString(root.val));
        return res;
    }
    
    private void updatePath(TreeNode root, String path) {
        if(root.left == null && root.right == null) {
            res.add(path);
            return;
        }       
        if(root.left != null) {
            updatePath(root.left, path + "->" + Integer.toString(root.left.val));
        }
        if(root.right != null) {
            updatePath(root.right, path + "->" + Integer.toString(root.right.val));
        }
    }
    
}