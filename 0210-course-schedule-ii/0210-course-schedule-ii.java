class Solution {
    ArrayList<Integer> res=new ArrayList<>();
    List<List<Integer>> adj=new ArrayList<>();
    int[] indegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            indegree[pre[0]]++;

            adj.get(pre[1]).add(pre[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                dfs(i);
            }
        }

        if(res.size() !=  numCourses) return new int[0];

        int ans[]=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            ans[i]=res.get(i);
        }

        return ans;
    }

    public void dfs(int node){
        res.add(node);
        indegree[node]--;
        for(int nei:adj.get(node)){
            indegree[nei]--;
            if(indegree[nei] == 0){
                dfs(nei);
            }
        }
    }
}