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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //层次遍历+栈
        Stack<List<Integer>> res = new Stack();
        Queue<TreeNode> tq = new LinkedList();
        if(root == null) return new ArrayList();
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
            res.push(l);
        }
        List<List<Integer>> end = new ArrayList();
        while(!res.isEmpty()) {
            end.add(res.pop());
        }
        return end;
    }
}