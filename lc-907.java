class Solution {
    public int sumSubarrayMins(int[] A) {
        int modnum = (int)1e9+7;
        int res = 0;
        //int[] count = new int[A.length];
        for(int i = 0; i<A.length; i++) {
            int l = 1, r = 1;
            for(int j = i-1; j>=0 && A[j]>A[i]; j--)l++;
            for(int k = i+1; k<A.length && A[k]>=A[i]; k++)r++;
            int count = l*r;
            res += count*A[i];
            res %= modnum;
        }
        return res;
    }
}