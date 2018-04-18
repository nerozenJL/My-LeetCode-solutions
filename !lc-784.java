class Solution {
    private List<String> res = new ArrayList();
    public List<String> letterCasePermutation(String S) {
        Queue<String> q = new LinkedList();
        q.offer(S);
        
        for(int i = 0; i<S.length(); i++) {
            char a = S.charAt(i);
            
            if(Character.isDigit(a)) continue;//使用了isDigit方法
            
            int size = q.size();
            while(size>0) {
                char[] s = q.poll().toCharArray();
                s[i]=Character.toLowerCase(s[i]);
                q.offer(String.valueOf(s));
                s[i]=Character.toUpperCase(s[i]);
                q.offer(String.valueOf(s));
                size--;
            }
        }
        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}