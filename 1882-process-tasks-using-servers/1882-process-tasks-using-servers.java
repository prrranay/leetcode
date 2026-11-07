class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<int[]> free=new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1]-b[1]);
        int n=servers.length;
        int m=tasks.length;


        for(int i=0;i<n;i++){
            free.offer(new int[]{servers[i],i});
        }

        Queue<long[]> busy=new PriorityQueue<>((a,b) ->{
            if(a[0] != b[0]) return Long.compare(a[0],b[0]);
            if(a[1] != b[1]) return Long.compare(a[1],b[1]);
            return Long.compare(a[2],b[2]);
        });


        int[] ans=new int[m];

        for(int i=0;i<m;i++){
            while(!busy.isEmpty() && busy.peek()[0] <= i){
                long[] curr=busy.poll();
                free.offer(new int[]{(int)curr[1],(int)curr[2]});
            }


            if(!free.isEmpty()){
                int[] curr=free.poll();
                ans[i]=curr[1];
                busy.offer(new long[]{(long)i+tasks[i],curr[0],curr[1]});
            }else{
                long[] curr=busy.poll();
                ans[i]=(int)curr[2];
                busy.offer(new long[]{curr[0]+tasks[i],curr[1],curr[2]});
            }
        }
        return ans;
    }
}