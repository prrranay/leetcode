class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph =new HashMap<>();
        
        for(int[] edge:times){
            if(!graph.containsKey(edge[0])){
                List<int[]> list =new ArrayList<>();
                graph.put(edge[0],list);
            }
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        Queue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{k,0});
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;


        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int currNode=current[0];
            int currDist=current[1];

            if(currDist > distance[currNode]){
                continue;
            }

            if(graph.containsKey(currNode)){
                for(int[] ne:graph.get(currNode)){
                    int nextNode=ne[0];
                    int nextDist=currDist+ne[1];

                    if(nextDist < distance[nextNode]){
                        distance[nextNode]=nextDist;
                        pq.offer(new int[]{nextNode,nextDist});
                    }
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            max=Math.max(max,distance[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}