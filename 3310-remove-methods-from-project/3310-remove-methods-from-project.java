class Solution {
    void dfs(boolean[] vis, int node,HashMap<Integer,List<Integer>> map ){
        vis[node]=true;

        if(!map.containsKey(node)) return;

        for(int next:map.get(node)){
            if(!vis[next]){
                dfs(vis,next,map);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int[] inv:invocations){
            int u=inv[0];
            int v= inv[1];
            if(!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
            map.get(u).add(v);
        }

        boolean vis[]=new boolean[n];
        dfs(vis,k,map);

        List<Integer> res=new ArrayList<>();

        for(int[] inv:invocations){
            int u=inv[0];
            int v= inv[1];

            if(!vis[u] && vis[v]){
                for(int i=0;i<n;i++){
                    res.add(i);
                }
                return res;
            }
        }
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                res.add(i);
            }
        }

        return res;
    }
}