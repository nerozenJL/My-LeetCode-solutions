class Solution {
    public int countSegments(String s) {
        int num = 0;
        int i = toNextValidChar(s, 0);
        while(i < s.length()) {
            if(s.charAt(i) == ' ') { 
                num++;
                i = toNextValidChar(s, i+1);        
            }else {
                if(i == s.length()-1) num++;
                i++;
            }
        }
        return num;
    }
    private int toNextValidChar(String s, int i) {
        while(i < s.length()) {
            if(s.charAt(i) != ' ') break;
            else i++;
        }
        return i;
    }
}