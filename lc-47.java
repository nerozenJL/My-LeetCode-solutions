class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] v = new boolean[nums.length];
        boolean[] d = new boolean[nums.length];
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        permutation(nums, new ArrayList(), v, res);
        return res;
    }
    
    private void permutation(int[] nums, List<Integer> comb, boolean[] v, List<List<Integer>> res) {
        if(comb.size() == nums.length) {
            res.add(new ArrayList(comb));
        }else {
            for(int i = 0; i<nums.length; i++) {
                if(v[i] == true) continue;
                if(i>0 && (nums[i] == nums[i-1] && v[i-1] == false)) continue;
                comb.add(nums[i]);
                v[i] = true;
                permutation(nums, comb, v, res);
                v[i] = false;
                comb.remove(comb.size()-1);
            }
        }
    }
}