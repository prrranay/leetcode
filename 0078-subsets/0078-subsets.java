class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(0,nums,new ArrayList<>());
        return ans;
    }

    void solve(int i, int[]nums,List<Integer> curr){
        ans.add(new ArrayList<>(curr));

        for(int j=i;j<nums.length;j++){
            curr.add(nums[j]);
            solve(j+1,nums,curr);
            curr.remove(curr.size()-1);
        }
    }
}