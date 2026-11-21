class Solution {
    final int INF=Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n];

        Arrays.fill(dist,INF);
        dist[k-1]=0;

        for(int i=1;i<n;i++){
            for(int[] edge:times){
                int u=edge[0]-1,v=edge[1]-1,w=edge[2];

                if(dist[u] != INF && dist[u]+w < dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int num:dist){
            max=Math.max(max,num);
        }

        return max != INF ? max : -1;
    }
}