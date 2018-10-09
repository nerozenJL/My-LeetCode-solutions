class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        int alex = 0;
        for(int num : piles) {
            sum+=num;
        }
        for(int l = 0, r = piles.length-1; l<r; l++, r--) {
            alex+=Math.max(piles[l], piles[r]);
        }
        
        return alex>(sum-alex)?true:false;
    }
}