class Solution {
    Map<String,List<String>> graph=new HashMap<>();
    List<String> ans=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket:tickets){
            String from=ticket.get(0);
            String to= ticket.get(1);
            if(!graph.containsKey(from)){
                graph.put(from,new ArrayList<>());
            }
            graph.get(from).add(to);
        }

        for(List<String> destination:graph.values()){
            Collections.sort(destination);
        }
        dfs("JFK");
        return ans;
    }

    public void dfs(String terminal){
        List<String> destination=graph.get(terminal);

        while(destination != null && !destination.isEmpty()){
            String next=destination.remove(0);
            dfs(next);
        }

        ans.addFirst(terminal);
    }
}