class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList());
        return res;
    }
    private void find(int[] cs, int target, int s, List comb) {
        if(target<0) return;
        if(target == 0) res.add(new ArrayList(comb));
        if(target > 0) {
            for(int i = s; i<cs.length; i++) {
                if(i>s && cs[i]==cs[i-1]) continue; //这个太妙了，要仔细揣摩，其实还并未理解
                comb.add(cs[i]);
                find(cs, target-cs[i], i+1, comb);
                comb.remove(comb.size()-1);
            }
        }
    }
}