class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> freq=new HashMap<>();

        for(int num:arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        Queue<Integer> pq=new PriorityQueue<>((a,b) -> b-a);

        for(int key:freq.keySet()){
            pq.offer(freq.get(key));
        }        
        int target=arr.length/2;
        int removed=0;
        int ans=0;

        while(removed < target && !pq.isEmpty()){
            removed+=pq.poll();
            ans++;
        }
        return ans;
    }
}