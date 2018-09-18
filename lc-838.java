class Solution {
    public String pushDominoes(String dominoes) {
        boolean flag = true;
        String last = new String(dominoes);
        StringBuilder now = new StringBuilder(dominoes);
        
        //边界输出
        if(dominoes.length() == 1)return dominoes;
        if(dominoes.length() == 2) {
            if(dominoes.charAt(0) == '.' && dominoes.charAt(1) == 'L') now.setCharAt(0, 'L');
            if(dominoes.charAt(0) == 'R' && dominoes.charAt(1) == '.') now.setCharAt(1, 'R');
            return now.toString();
        }
        
        
        while(flag) {
            flag = false;
            for(int i = 1; i<dominoes.length()-1; i++) {
                if(now.charAt(i) == '.') {
                    char l = last.charAt(i-1);
                    char r = last.charAt(i+1);
                    if(l == 'R' && r == 'L') {
                        now.setCharAt(i, '.');
                    }else if(l == 'R') {
                        now.setCharAt(i, 'R');
                        flag = true;
                    }else if(r == 'L'){
                        now.setCharAt(i, 'L');
                        flag = true;
                    }
                }
            }
            last = now.toString();
        }
        if(now.charAt(1) == 'L' && now.charAt(0) == '.') now.setCharAt(0, 'L');
        if(now.charAt(now.length()-2) == 'R' && now.charAt(now.length()-1) == '.')now.setCharAt(now.length()-1, 'R');
        return now.toString();
    }
}