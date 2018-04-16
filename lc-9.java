class Solution {
    public boolean isPalindrome(int x) {
        String str_num = Integer.toString(x);
        char[] array = str_num.toCharArray();
        int a = array.length-1;
        for(int i = str_num.length()/2; i<str_num.length(); i++) {
            if(array[i] != array[a-i])return false;
        }
        return true;
    }
}