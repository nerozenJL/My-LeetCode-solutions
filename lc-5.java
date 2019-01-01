class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        String res = "";
        int max = 0;
        //搞清楚遍历顺序
        for(int j = 0; j<s.length(); j++) {
            for(int i = 0; i<=j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j)
                    && (j-i <= 2 || dp[i+1][j-1]);
                if(dp[i][j]) {
                    max = Math.max(max, j - i + 1);
                    // System.out.println(max);
                    res = max==j-i+1?s.substring(i, j+1):res;
                }
            }
        }
        
        return res;
    }
}