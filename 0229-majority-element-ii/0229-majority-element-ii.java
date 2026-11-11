class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int n=nums.length/3;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num) == n+1){
                ans.add(num);
            }
        }
        return ans;
    }
}