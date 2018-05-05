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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> tq = new LinkedList();
        if(root == null) return res;
        tq.offer(root);
        while(!tq.isEmpty()) {
            int laylen = tq.size();
            List<Integer> l = new ArrayList();
            while(laylen>0) {
                TreeNode t = tq.poll();
                l.add(t.val);
                if(t.left != null)tq.offer(t.left);
                if(t.right != null)tq.offer(t.right);
                laylen--;
            }
            res.add(l);
        }
        return res;
    }
}