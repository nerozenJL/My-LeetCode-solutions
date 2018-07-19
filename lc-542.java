class Solution {
    public int[][] updateMatrix(int[][] m) {
        int[][] res = new int[m.length][m[0].length];
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i<res.length; i++) {
            for(int j = 0; j<res[0].length; j++) {
                res[i][j] = m[i][j] == 0?0:Integer.MAX_VALUE; //初始化结果矩阵，0元素为0，非零元素为无穷
                if(res[i][j] == 0) q.offer(new int[]{i, j});
            }
        }
        
        int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!q.isEmpty()) {
            int[] n = q.poll();
            for(int[] mv : move) {
                int ni = n[0] + mv[0];
                int nj = n[1] + mv[1];
                if(ni >= 0 && ni < res.length && nj >= 0 && nj < m[0].length) {
                    if(res[ni][nj] > res[n[0]][n[1]]) res[ni][nj] = res[n[0]][n[1]] + 1;
                    else continue;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return res;
    }

}