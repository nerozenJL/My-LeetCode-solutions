class Solution {
    
    //上右下左
    int[] hori = {0, 1, 0, -1};
    int[] vert = {1, 0, -1, 0};
    
    public boolean exist(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(search(check, board, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    
    private boolean search(boolean[][] check, char[][] board,int r, int c, int index, String word) {
        if(index == word.length()) return true; //遍历完word
        if(r >= check.length || r < 0 || c >= check[0].length || c <0) return false; //越界
        if(check[r][c]) return false; //访问过
        if(word.charAt(index) != board[r][c]) return false;
        
        check[r][c] = true;
        
        for(int i = 0; i<4; i++) {
            if(search(check, board, r + vert[i], c + hori[i], index+1, word)) return true;
        }
        
        check[r][c] = false; //backtracking的关键
        
        return false;
    }
}