class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> cl = new ArrayList();
        int[] res = new int[S.length()];
        for(int i = 0; i<S.length(); i++) {
            char a = S.charAt(i);
            if(a == C) {
                cl.add(i);
            }
        }
        for(int i = 0; i<res.length; i++) {
            res[i] = Integer.MAX_VALUE;
            for(int ci : cl) {
                res[i] = Math.min(res[i], Math.abs(ci - i));
            }
        }
        return res;
    }
}