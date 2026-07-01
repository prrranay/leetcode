class Solution {
    int [][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();

        //step -1 compute distance
        int[][] dist= new int[n][n];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }

        //push thieves in queue
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)== 1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        // multi source bfs
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            int r= cur[0];
            int c=cur[1];

            for(int[]d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0|| nc< 0|| nr>=n||nc>=n){
                    continue;
                }
                if(dist[nr][nc]!= -1) continue;

                dist[nr][nc]=dist[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
        }

        int low =0;
        int high=2*n;
        int ans=0;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(canReach(dist,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    private boolean canReach(int[][] dist,int safe){
        int n=dist.length;
        if(dist[0][0]<safe){
            return false;
        }

        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis= new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();

            int r=cur[0];
            int c=cur[1];

            if(r== n-1 && c==n-1) return true;

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc= c+d[1];

                if(nr<0|| nc<0|| nr>=n|| nc>=n) continue;
                if(vis[nr][nc]) continue;
                if(dist[nr][nc]<safe) continue;

                vis[nr][nc]=true;
                q.offer(new int[]{nr,nc});
            }
        }
        return false;
    }
}