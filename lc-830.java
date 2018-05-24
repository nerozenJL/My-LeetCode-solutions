class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList();
        if(S == null || S.length() < 3) return res;
        Integer si = null;
        Integer ei = null;
        for(int i = 1; i<S.length(); i++) {
            if(S.charAt(i) == S.charAt(i-1)) {
                if(si == null) {
                    si = i-1;
                    ei = i;
                }else {
                    ei = i;
                }
                //System.out.println(si + " " + ei);
            }else {
                if(si != null) {
                    if(ei - si >= 2){
                        List<Integer> g = new ArrayList();
                        g.add(si);
                        g.add(ei);
                        res.add(g);
                    }
                    si = null;
                    ei = null;
                }
            }
            if(i == S.length()-1) {
                if(si != null) {
                    if(ei - si >= 2){
                        List<Integer> g = new ArrayList();
                        g.add(si);
                        g.add(ei);
                        res.add(g);
                    }
                    si = null;
                    ei = null;
                }
            }
        }
        return res;
    }
}