class Solution {
    public String largestTimeFromDigits(int[] A) {
        int res = -1;
        
        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A.length; j++) if(j!=i) {
                for(int k = 0; k<A.length; k++) if(k != j && k != i) {
                    int l = 6-i-j-k; // 6=0+1+2+3
                    
                    int hour = A[i]*10 + A[j];
                    int mins = A[k]*10 + A[l];
                    // System.out.println
                    if(hour < 24 && mins < 60) {
                        res = Math.max(res, hour * 60 + mins);
                    }
                }
            }
        }
        return (res == -1)?"":String.format("%02d:%02d", res/60, res%60);
    }
}