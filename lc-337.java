class Solution {
    private Map<TreeNode, Integer> nodeMaxRob = new HashMap();
    public int rob(TreeNode r) {
        if(r == null) return 0;
        int maxrob = 0;
        if(r.left == null && r.right == null) maxrob += r.val;
        else {
            int child = rob(r.left) + rob(r.right);
            int grandchilds = 0;
            if(r.left != null) {
                grandchilds += (nodeMaxRob.containsKey(r.left.left))?nodeMaxRob.get(r.left.left):rob(r.left.left);
                grandchilds += (nodeMaxRob.containsKey(r.left.right))?nodeMaxRob.get(r.left.right):rob(r.left.right);
            }
            if(r.right != null) {
                grandchilds += (nodeMaxRob.containsKey(r.right.left))?nodeMaxRob.get(r.right.left):rob(r.right.left);
                grandchilds += (nodeMaxRob.containsKey(r.right.right))?nodeMaxRob.get(r.right.right):rob(r.right.right);
            }
            maxrob = Math.max(child, grandchilds + r.val);
        }
        nodeMaxRob.put(r, maxrob);
        return maxrob;
    }
}