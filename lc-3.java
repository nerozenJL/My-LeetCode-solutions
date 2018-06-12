class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Integer> cimap = new HashMap();
        int starti = 0; 
        cimap.put(s.charAt(starti), starti);
        int maxlen = 1;
        for(int j = 1; j<s.length(); j++) {
            if(cimap.containsKey(s.charAt(j))) {
                //包含了重复
                if(j - starti > maxlen)maxlen = j-starti;
                int nextStart = cimap.get(s.charAt(j)) + 1;
                int end = cimap.get(s.charAt(j));
                for(int k = starti; k<=end; k++) {
                    cimap.remove(s.charAt(k));
                }
                starti = nextStart;
                cimap.put(s.charAt(j), j);
            }else {
                cimap.put(s.charAt(j), j);
                if(j - starti + 1 > maxlen)maxlen = j-starti + 1;
            }
        }
        return maxlen;
    }
}