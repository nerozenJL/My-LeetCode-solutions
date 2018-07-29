class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]); //降序的优先队列，大顶堆
        for(int i = 0; i<B.length; i++) {
            pq.add(new int[]{B[i], i});
        }
        int ai = A.length-1;
        int alow=0;
        int[] res = new int[A.length];
        while(!pq.isEmpty()) {
            int[] pair = pq.poll(); //取得当前B中最大的元素
            if(A[ai] > pair[0]) {
                res[pair[1]] = A[ai];
                ai--;
            }else {
                res[pair[1]] = A[alow];
                alow++;
            }
        }
        return res;
    }
}