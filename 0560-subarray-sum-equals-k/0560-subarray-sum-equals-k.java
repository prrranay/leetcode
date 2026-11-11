class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        int count=0;
        map.put(0,1);

        for(int num:nums){
            currSum+=num;
            int dif=currSum-k;
            count+=map.getOrDefault(dif,0);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}