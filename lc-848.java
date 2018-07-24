class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if(shifts == null) return S;
        for(int i = shifts.length-2; i>=0; i--) {
            shifts[i] += shifts[i+1];
            shifts[i] %= 26; //为什么要加这一步我觉得很困惑
        }
        //System.out.println(shifts[1]);
        char[] ca = S.toCharArray();
        for(int i = 0; i<ca.length; i++) {
            ca[i] = (char)((ca[i] + shifts[i] - 'a') % 26 + 'a');
        }
        return new String(ca);
    }
}