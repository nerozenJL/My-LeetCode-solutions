class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = k-1;
        int sum = 0;
        int res = 0;
        for(int i = l; i<=r; i++) {
            sum += nums[i];
        }
        res = sum;
        for(int j = r+1; j<nums.length; j++) {
           sum += nums[j];
           sum -= nums[l];
           if(sum > res) {
               res = sum;
           }
           l++; 
        }
        return (double)res / k;
    }
}