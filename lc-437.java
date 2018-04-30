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
    private int pnum = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        calculate(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pnum;
    }
    private void calculate(TreeNode t, int prev, int sum) {
        if(t==null)return;
        else if(prev+t.val == sum){
            pnum++;
        }
        calculate(t.left, prev+t.val, sum);
        calculate(t.right, prev+t.val, sum);
    }
}