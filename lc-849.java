class Solution {
    public int maxDistToClosest(int[] seats) {
        if(seats.length == 0) return 0;
        if(seats.length == 1) return 1;
        if(seats.length == 2) return 1;
        
        List<Integer> ps = new ArrayList();
        
        int max = 0;
        
        for(int i = 0; i<seats.length; i++) {
            if(seats[i] == 1) {
                if(!ps.isEmpty()) {
                    int lasti = ps.get(ps.size()-1);
                    max = Math.max(max, (i-lasti)/2);    
                }else {
                    max = Math.max(max, i);
                }
                ps.add(i);
            }else if(i == seats.length-1) {
                if(!ps.isEmpty()) {
                    max = Math.max(max, i - ps.get(ps.size()-1));
                }else {
                    max = Math.max(max, i);
                }
            }
        }
        return max;
    }
}