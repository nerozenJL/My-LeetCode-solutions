
// 这个不行的地方在于没有和前位做比较
// 比如 ["xga","xfb","yfa"]
// 第一位遵循字典（不严格字典），第二位不遵循，删除。但检查第三位的时候，只是简单地看到本位无序，但是前位（第一位）已经有序，所以也删除了
class Solution {
    public int minDeletionSize(String[] A) {
        int strlen = A[0].length();
        boolean end = true;
        int dnum = 0;
        
        outloopA:
        for(int i = 0; i<strlen; i++) {
            end = true;
            for(int j = 1; j<A.length; j++) {
                if(A[j].charAt(i)<A[j-1].charAt(i)) {
                    //直接可以删掉了
                    dnum++;
                    break;
                }
                if(A[j].charAt(i) == A[j-1].charAt(i)) {
                    //出现同字，循环需要继续
                    end = false;
                }
                
                if(j == A.length-1 && end) {
                    //这一层已经实现完全排序(没有同字),可直接结束
                    break outloopA;
                }
            }
        }
        return dnum;
    }
}

//正解
public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, j;

        //维护一个数组，表示那一位的字符队列是严格字典排序的（没有相同字符）
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) {
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    //前一位既不是严格字典（或者干脆无序），本位置无序，才能删掉这一位
                    res++;
                    break;
                }
            }
            if (i < n - 1) continue;
            for (i = 0; i < n - 1; ++i)
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sorted[i] = true;
        }
        return res;
    }