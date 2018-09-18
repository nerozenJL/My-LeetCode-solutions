class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList());
        return res;
    }
    private void find(int[] cs, int target, int s, List comb) {
        if(target > 0) {
            for(int i = s; i<cs.length; i++) {
                comb.add(cs[i]);
                find(cs, target-cs[i], i, comb);
                comb.remove(comb.size()-1);
            }
        }else if(target == 0){
            res.add(new ArrayList(comb));
            return;
        }else {
            //comb.remove(comb.size()-1);
            return;
        }
    }
}