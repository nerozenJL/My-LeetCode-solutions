class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        
        //方形，面积最大
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int maxL = 0;
        
        //横向扫描
        for(int j = 0; j<matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
            if(dp[0][j] > maxL) maxL = dp[0][j];
        }
        //纵向扫描
        for(int i = 1; i<matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0] > maxL) maxL = dp[i][0];
        } 
        
        
        //正式扫描
        for(int i = 1; i<matrix.length; i++) {
            for(int j = 1; j<matrix[0].length; j++) {
                int base = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                dp[i][j] = matrix[i][j] == '1'?base+1:0;
                if(dp[i][j] > maxL) maxL = dp[i][j];
            }
        }
        return maxL * maxL;
    }
}