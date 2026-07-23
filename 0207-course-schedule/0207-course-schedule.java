class Solution {
    Set<Integer> visited= new HashSet<>();
    public boolean canFinish(int num, int[][] pres) {
        HashMap<Integer,List<Integer>> graph=new HashMap<>();

        for(int[] pre:pres){
            if(graph.containsKey(pre[1])){
                graph.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> temp=new LinkedList<>();
                temp.add(pre[0]);
                graph.put(pre[1],temp);
            }
        }

        for(int i=0;i<num;i++){
            if(!solve(graph,i)){
                return false;
            }
        }
        return true;
    }

    public boolean solve(Map<Integer,List<Integer>> graph,int course){
        if(visited.contains(course)){
            return false;
        }
        if(graph.get(course)==null){
            return true;
        }

        visited.add(course);
        for(int i:graph.get(course)){
            if(!solve(graph,i)){
                return false;
            }
        }
        visited.remove(course);
        graph.put(course,null);
        return true;
    }
}