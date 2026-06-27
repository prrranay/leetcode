class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        if(map.containsKey(1)){
            if(map.get(1)%2 == 1){
                ans=map.get(1);
            }else{
                ans=map.get(1)-1;
            }
            map.remove(1);
        }

        for(int key:map.keySet()){
            long curr=key;
            int len=0;
            while(map.getOrDefault((int)curr,0) >=2){
                len+=2;
                curr=curr*curr;
            }
            if(map.getOrDefault((int)curr,0)>=1){
                len++;
            }else{
                len--;
            }
            ans=Math.max(len,ans);
        }
        return ans;
    }
}