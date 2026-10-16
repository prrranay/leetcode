class Solution {
    int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int[] dir:directions){
                int i=dir[0]+x;
                int j=dir[1]+y;

                if(i>=0 && j>=0 && i<n && j<n && dist[i][j] == -1){
                    dist[i][j]=dist[x][y]+1;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int start=0;
        int end=2*n;

        int ans=0;

        while(start <= end){
            int mid=(start+end)/2;

            if(canReach(dist,mid)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }

    boolean canReach(int[][] dist, int safe){
        if(dist[0][0] < safe){
            return false;
        }

        int n=dist.length;

        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){
            int[]curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            if(x == n-1 && y == n-1) return true;
            for(int[] dir:directions){
                int i=dir[0]+x;
                int j=dir[1]+y;

                if(i>=0 && j>= 0 && i<n && j<n && !vis[i][j] && dist[i][j]>= safe){
                    vis[i][j]=true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        return false;
    }
}