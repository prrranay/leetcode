class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int ans=0;
        for(int num:set){
            if(!set.contains(num-1)){
             int curr=1;
                int currNum=num;
                while(set.contains(currNum+1)){
                    curr++;
                    currNum++;
                }
                ans=Math.max(curr,ans);
            }
        }
        return ans;
    }
}