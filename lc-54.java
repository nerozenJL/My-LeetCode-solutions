class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        if(m.length == 0 || m[0].length == 0) return new ArrayList();
        boolean[][] tm = new boolean[m.length][m[0].length];
        List<Integer> res = new ArrayList();
        int finaln = m.length * m[0].length;
        
        //先水平，后垂直
        int i = 0, j = 0;
        int num = 0;
        int direction = 1;
        while(num < finaln) {
            switch(direction) {
                case 1: //向右
                    while(j<=m[0].length-1 && !tm[i][j]) {
                        System.out.println(i + " " + j);
                        res.add(m[i][j]);
                        tm[i][j] = true;
                        num++;
                        j++;
                        
                    }
                    i++;
                    j--;
                    break;
                case 2: //向下
                    while(i <= m.length-1 && !tm[i][j]) {
                        System.out.println(i + " " + j);
                        res.add(m[i][j]);
                        tm[i][j] = true;
                        num++;
                        i++;
                    }
                    j--;
                    i--;
                    break;
                case 3: //向左
                    while(j>=0 && !tm[i][j]) {
                        System.out.println(i + " " + j);
                        res.add(m[i][j]);
                        tm[i][j] = true;
                        j--;
                        num++;
                    }
                     
                    //System.out.println(i + " " + j);
                    i--;
                    j++;
                    break;
                case 4: //向上
                    while(!tm[i][j]) {
                        System.out.println(i + " " + j);
                        res.add(m[i][j]);
                        tm[i][j] = true;
                        i--;
                        num++;
                    }
                    j++;
                    i++;
                    break;
            }
            direction = direction == 4?1:direction+1;
        }
        return res;
    }
}