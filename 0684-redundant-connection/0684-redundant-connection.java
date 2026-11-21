class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 1; i < edges.length + 1; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a=edge[0];
            int b=edge[1];

            int rootA=find(a);
            int rootB=find(b);

            if(rootA == rootB){
                return edge;
            }

            parent[rootB]=rootA;
        }

        return new int[0];
    }

    public int find(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}