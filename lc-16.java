class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo = nums[0] + nums[1] + nums[2];
        for(int i = 0; i<nums.length-2; i++) {
            int mid = i+1, tail = nums.length-1;
            while(mid<tail) {
                int sum = nums[i] + nums[mid] + nums[tail];
                clo = Math.abs(sum-target) < Math.abs(clo-target)?sum:clo;
                if(sum > target) tail--;
                else mid++;
            }
        }
        return clo;
    }
}