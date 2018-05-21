class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int[] res = new int[A.length];
        res[0] = res[1] = 0;
        res[2] = (A[2] - A[1] == A[1] - A[0]?1:0);
        for(int i = 3; i<A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                res[i] = res[i-1] + (res[i-1] - res[i-2]) + 1;
            }else{
                res[i] = res[i-1];
            }
        }
        return res[A.length-1];
    }
}