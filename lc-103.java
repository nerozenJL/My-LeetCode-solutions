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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> tq = new LinkedList();
        if(root == null) return res;
        tq.offer(root);
        boolean odd = true;
        while(!tq.isEmpty()) {
            int laylen = tq.size();
            List<Integer> l = new ArrayList();
            while(laylen>0) {
                TreeNode t = tq.poll();
                
                if(odd){
                    l.add(t.val);
                }else{
                    l.add(0, t.val);
                }
                
                if(t.left != null)tq.offer(t.left);
                if(t.right != null)tq.offer(t.right);
                laylen--;
            }
            odd = !odd;
            res.add(l);
        }
        return res;
    }
}