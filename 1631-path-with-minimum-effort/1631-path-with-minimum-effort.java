class Solution {
    int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0,0,0});
        dist[0][0]=0;

        while(!minHeap.isEmpty()){
            int[] top=minHeap.poll();

            int d=top[0], x=top[1], y=top[2];

            if(d > dist[x][y]) continue;

            if(x == m-1 && y == n-1) return d;

            for(int[] dir:directions){
                int i=dir[0]+x;
                int j=dir[1]+y;

                if(i>=0 && j>=0 && i<m && j<n){
                    int newDist= Math.max(d,Math.abs(heights[i][j]-heights[x][y]));
                    
                    if(newDist< dist[i][j]){
                        dist[i][j]=newDist;
                        minHeap.offer(new int[]{newDist,i,j});
                    }
                }
            }
        }

        return 0;
    }
}