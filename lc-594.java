class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> records = new HashMap();
        for(int a : nums) {
            records.put(a, records.getOrDefault(a, 0)+1);
        }
        int maxlen = 0;
        for(int a : records.keySet()) {
            if(records.containsKey(a+1)) {
                maxlen = Math.max(maxlen, records.get(a) + records.get(a+1));
            }
            if(records.containsKey(a-1)) {
                maxlen = Math.max(maxlen, records.get(a) + records.get(a-1));
            }
        }
        return maxlen;
    }
}