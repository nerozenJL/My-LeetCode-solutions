class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() == 0 || s.length()<k) return 0;
        int maxl = Integer.MIN_VALUE;
        int[] c = new int[26];
        for(char ch : s.toCharArray()) {
            c[ch-'a']++;
        }
        for(int i = 0; i<s.length(); i++) {
            if(c[s.charAt(i)-'a']<k) {
                //分割
                String[] sp = s.split((String)("" + s.charAt(i)));
                for(String a : sp) maxl = Math.max(maxl, longestSubstring(a, k));
                break;
            }
            if(i == s.length()-1) maxl = s.length();
        }
        return maxl;
    }
}