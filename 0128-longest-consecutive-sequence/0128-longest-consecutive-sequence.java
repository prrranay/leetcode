class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int num:nums) set.add(num);

        int ans=0;
        for(int num:set){

            if(!set.contains(num-1)){
                int curr=1;
                int currNum=num+1;
                while(set.contains(currNum++)){
                    curr++;
                }

                ans=Math.max(ans,curr);
            }
        }

        return ans;
    }
}