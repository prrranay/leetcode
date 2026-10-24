class Solution {
    Set<Integer> visited=new HashSet<>();
    Map<Integer,List<Integer>> map=new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int []pre:prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!solve(i)){
                return false;
            }
        }

        return true;
    }


    public boolean solve(int course){
        if(visited.contains(course)){
            return false;
        }

        if(map.get(course) == null){
            return true;
        }

        visited.add(course);

        for(int nei:map.get(course)){
            if(!solve(nei)){
                return false;
            }
        }

        visited.remove(course);
        map.put(course,null);
        return true;
    }
}