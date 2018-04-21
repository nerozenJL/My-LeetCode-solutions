public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int r = n;
        int l = 1;
        
        return check(l, r);
    }
    private int check(int l, int r) {
        switch(guess(l + (r-l)/2)) {
            case 0:
                return l + (r-l)/2;
            case 1:
                return check(l + (r-l)/2 + 1, r);
            case -1:
                return check(l, l + (r-l)/2 - 1);
        }
        return 0;
    }
}