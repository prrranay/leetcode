class Solution {
    boolean[]vis;

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        vis=new boolean[n];
        int ans=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(isConnected,i);
                ans++;
            }
        }
        return ans;
    }

    public void bfs(int[][] graph,int start){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int city=q.poll();
            for(int i=0;i<graph.length;i++){
                if(graph[city][i]==1 && !vis[i]){
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
    }
}