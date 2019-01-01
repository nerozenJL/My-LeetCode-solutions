public class LC73Solution {
    public void setZeroes(int[][] m) {
        int row = m.length;
        int col = m[0].length;

        int no0r = -1;

        //记录所有行
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(m[i][j] == 0) {
                    continue;
                }
                if(j == col-1) no0r = i;
            }
            if(no0r != -1) break;
        }

        //如果全有0，矩阵全部置为0
        if(no0r == -1) {
            for(int i = 0; i<row; i++)
                for(int j = 0; j<col; j++)
                    m[i][j]=0;
            return ;
        }

        //以不含0的那一行为据点扩散列
        for(int j = 0; j<col; j++) {
            for(int i = 0; i<row; i++) {
                if(m[i][j] == 0) {
                    m[no0r][j] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(m[i][j] == 0) {
                    setRowzero(m, i);
                    continue;
                }
            }
        }

        for(int j = 0; j<col; j++) {
            if(m[no0r][j] == 0) {
                setColzero(m, j);
                continue;
            }
        }

    }


    void setRowzero(int[][] m, int row) {
        for(int j = 0; j<m[0].length; j++)
            m[row][j] = 0;
    }

    void setColzero(int[][] m, int col) {
        for(int i = 0; i<m.length; i++)
            m[i][col] = 0;
    }
}