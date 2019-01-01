// 贪心
class Solution {
    public int[] diStringMatch(String S) {
        int l = 0, r = S.length();
        int[] res = new int[r+1];
        
        for(int i = 0; i<S.length(); i++) {
            if(S.charAt(i) == 'I') 
                res[i] = l++;
            else
                res[i] = r--;
        }
        res[res.length-1]=l;
        return res;
    }
}