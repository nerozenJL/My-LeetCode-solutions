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
    private Set<String> paths = new HashSet();
    //private Set<TreeNode> res = new HashSet();
    private Map<String, TreeNode> Res = new HashMap();
    public List<TreeNode> findDuplicateSubtrees(TreeNode r) {
        //走一遍后续遍历?试试
        checkDuplicate(r);
        return new ArrayList(Res.values());
    }
    private String checkDuplicate(TreeNode root) {
        if(root == null) return null;
        else {
           String rootp = ""; 
           String lp = checkDuplicate(root.left);
           String rp = checkDuplicate(root.right);
           rootp += lp == null?"":lp+"L";
           rootp += root.val;
           rootp += rp == null?"":"R"+rp;
           //System.out.println(rootp); 
           if(paths.contains(rootp) && !Res.containsKey(rootp)){
               Res.put(rootp, root);
           }
           else paths.add(rootp);
           return rootp; 
        }
    }
}