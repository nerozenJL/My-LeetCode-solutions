class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        
        int l = 0, r = A.length-1;
        
        for(int num : A) {
            if(num % 2 == 0) {
                res[l++] = num;
            }else {
                res[r--] = num;
            }
        }
        
        return res;
    }
}