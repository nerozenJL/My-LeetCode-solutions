class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        int i = 1;
        int count = 1;
        
        while(count <= n) {
            res.add(i);
            count++;
            
            if(i*10 <= n) {
                i*=10;
            }else {
                while(i % 10 == 9 || i+1>n) {
                    i/=10;
                }
                i++;
            }
        }
        return res;
    }
}