class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] a : A) {
            a = reverse(a);
        }
        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                A[i][j] = (A[i][j] == 0?1:0);
            }
        }
        return A;
    }
    private int[] reverse(int[] A) {
        int l = 0, r = A.length-1;
        while(l<r) {
            A[l] = A[l] + A[r];
            A[r] = A[l] - A[r];
            A[l] = A[l] - A[r];
            l++;
            r--;
        }
        return A;
    }
}