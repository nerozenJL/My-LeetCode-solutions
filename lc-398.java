class Solution {
    Map<Integer, List<Integer>> m = new HashMap();
    Random rand = new Random();
    
    public Solution(int[] nums) {
        //m = new HashMap();
        for(int i = 0; i<nums.length; i++) {
            List<Integer> l = m.getOrDefault(nums[i], new ArrayList());
            l.add(i);
            m.put(nums[i], l);       
        }
    }
    
    public int pick(int target) {
        List<Integer> l = m.get(target);
        int idx=rand.nextInt(l.size());
        return l.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */