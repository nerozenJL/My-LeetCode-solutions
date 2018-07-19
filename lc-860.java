class Solution {
    public boolean lemonadeChange(int[] bills) {
        int charge5 = 0, charge10 = 0;
        for(int pay : bills) {
            if(pay == 5) {
                charge5++;
                continue;
            }else if(pay == 10) {
                if(charge5>0) {
                    charge10++;
                    charge5--;
                    continue;
                }else return false;
            }else {
                while(charge10>0 && pay > 10) {
                    pay-=10;
                    charge10--;
                }
                while(charge5>0 && pay > 5) {
                    pay-=5;
                    charge5--;
                }
                if(pay > 5) return false;
            }
        }
        return true;
    }
}