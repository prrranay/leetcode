class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();

        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }

        Queue<Integer> pq=new PriorityQueue<>((a,b) -> b - a);

        pq.addAll(map.values());
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();

            for(int i=0;i<n+1;i++){
                if(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }

            for(int freq:temp){
                if(--freq >0){
                    pq.offer(freq);
                }
            }

            time += pq.isEmpty()? temp.size():n+1;
        }

        return time;
    }
}