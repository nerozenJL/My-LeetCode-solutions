class Solution {
    public int[] findDiagonalOrder(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0) return new int[0];
        int[] res = new int[m.length * m[0].length];
        //必然从(0,0)开始，且向右开始
        //向上运动，横坐标-1，纵坐标+1，向下反之
        res[0] = m[0][0];
        int i = 0, j = 0;
        int k = 1;
        int num = 1;
        boolean down = true;
        
        if(m[0].length < 2) {
            down = false;
            i++;
        }else{
            j++;
        }
        
        while(num < res.length) {
            if(down) {
                //向下
                //System.out.println(i + " " + j);
                while(i < m.length && j >= 0) {
                    //System.out.println(i + " " + j);
                    res[k] = m[i][j];
                    i++;
                    j--;
                    k++;
                }
                //正常情况 j不变，i+1
                //i到了底部，i不变,j+1
                i--;
                j++;
                //恢复到最后一次
                if(i<m.length-1) {
                    i++;
                }else {
                    j++;
                }
                down = false;
            }else {
                //向上
                while(j < m[0].length && i >= 0) {
                    //System.out.println(i + " " + j);
                    res[k] = m[i][j];
                    i--;
                    j++;
                    k++;
                }
                i++;
                j--;
                if(j<m[0].length-1) {
                    j++;
                }else {
                    i++;
                }
                down = true;
            }
            num++;
        }
        return res;
    }
}