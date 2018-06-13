class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack();
        Stack<Character> st = new Stack();
        
        for(char a : S.toCharArray()) {
            if(a == '#' && !ss.isEmpty()) {
                ss.pop();
            }else if(a != '#'){
                ss.push(a);
            }
        }
        for(char a : T.toCharArray()) {
            if(a == '#' && !st.isEmpty()) {
                st.pop();
            }else if(a != '#'){
                st.push(a);
            }
        }
        if(st.size()!=ss.size()) return false;
        
        while(!st.isEmpty()) {
            if(st.pop() != ss.pop()) return false;
        }
        return true;
    }
}