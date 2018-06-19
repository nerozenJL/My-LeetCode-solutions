class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList();
        List<Integer> a = Arrays.asList(1);
        List<Integer> b = Arrays.asList(1, 1);
        List<List<Integer>> res = new ArrayList();
        if(numRows == 1) {
            res.add(a);
            return res;
        }
        if(numRows == 2) {
            res.add(a);
            res.add(b);
            return res;
        }
        
        res.add(a);
        res.add(b);
        
        int line = 3;
        while(line <= numRows) {
            List<Integer> last = res.get(res.size()-1);
            List<Integer> now = new ArrayList();
            
            now.add(1);
            
            for(int i = 1; i<last.size(); i++) {
                now.add(last.get(i) + last.get(i-1));
            }
            
            now.add(1);
            
            res.add(now);
            line++;
        }
        return res;
    }
}