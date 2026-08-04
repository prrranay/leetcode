class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1 != nums[i+1]){
                int k=nums[i]+1;
                while(k != nums[i+1]){
                    res.add(k);
                    k++;
                }
            }
        }
        return res;
    }
}