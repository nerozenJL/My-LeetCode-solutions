class Solution {
    public int maxSubarraySumCircular(int[] A) {
        //int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        int asum = 0, //数组总和
        maxSum = Integer.MIN_VALUE,
        curMax = 0,
        minSum = Integer.MAX_VALUE,
        curMin = 0;
        for(int i = 0; i<A.length; i++) {
            asum += A[i];
            curMax = Math.max(curMax + A[i], A[i]);
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(curMin + A[i], A[i]);
            minSum = Math.min(curMin, minSum);
        }
        
        return (minSum < 0 && minSum == asum)?maxSum:Math.max(maxSum, asum - minSum);
    }
}