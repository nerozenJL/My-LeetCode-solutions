class Solution {
    public String predictPartyVictory(String s) {
        StringBuilder senate = new StringBuilder(s);
        String result = "";
        int nexti = 0;
        while(true) {
            boolean enemy = false;
            char now = senate.charAt(nexti);
            for(int i = nexti+1; i<senate.length(); i++) {
                //注意要轮转循环
                if(senate.charAt(i) != now) {
                    senate.deleteCharAt(i);
                    enemy = true;
                    break;
                }
            }
            if(!enemy) {
                for(int i = 0; i<nexti; i++) {
                   if(senate.charAt(i) != now) {
                        senate.deleteCharAt(i);
                        enemy = true;
                        nexti--;//因为被删除的字符在nexti前面，所以要注意此处要修正nexti的位置
                        break;
                    } 
                }
            }
            if(!enemy) {
                result = senate.charAt(nexti) == 'R'?"Radiant":"Dire";
                break;
            }else {
                nexti = nexti+1<senate.length()?nexti+1:0;
            }
            //System.out.println(senate);
        }
        return result;
        
    }
}