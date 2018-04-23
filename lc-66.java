class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        for(int i = digits.length-1; i>=0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            }else {
                digits[i]++;
                break;
            }
            if(i==0 && digits[i] == 0) {
                res[0] = 1;
                for(int j = 1; j<res.length; j++) {
                    res[j] = digits[j-1];
                }
                return res;
            }
        }
        return digits;
    }
}