class Solution {
    public int uniquePaths(int m, int n) {
        if(m<2 || n<2) return 1;
        int[][] mx = new int[m][n];
        mx[0][1] = 1;
        mx[1][0] = 1;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(i-1>=0) mx[i][j] += mx[i-1][j];
                if(j-1>=0) mx[i][j] += mx[i][j-1];
            }
        }
        return mx[m-1][n-1];
    }
}