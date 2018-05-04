//use set
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        for(int i = 0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                for(int j = i-1; j>=0 && (i-j)<=k; j--) {
                    if(nums[i] == nums[j]) {
                        return true;
                    }
                }
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}



//brute force O(n*k) 最坏时间O(n^2)，TLE
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i<nums.length; i++) {
            for(int j = 1; j<=k; j++) {
                if(i+j<nums.length) {
                    if(nums[i] == nums[i+j]) return true;
                }else {
                    break;
                }
            }
        }
        return false;
    }
}