class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
        int n=parent.length;
        List<Integer>[] child= new ArrayList[n];

        for(int i=0;i<n;i++){
            child[i]=new ArrayList<>();
        }

        for(int i=1;i<n;i++){
            child[parent[i]].add(i);
        }

        return dfs(op,score,0,child);
    }

    public int dfs(int[]op,int[] score,int node,List<Integer>[] child){
        if(child[node].isEmpty()){
            return score[node];
        }

        int min=Integer.MAX_VALUE;
        int total=0;
        for(int c:child[node]){
            int val=dfs(op,score,c,child);
            min=Math.min(min,val);
            total+=val;
        }


        if(op[node] == 1){
            total-=min;
        }else if(min<0){
            total-=min;
        }

        return score[node]+total;
    }
}