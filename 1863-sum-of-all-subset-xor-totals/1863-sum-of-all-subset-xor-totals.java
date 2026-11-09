class Solution {
    List<Integer> sum=new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        solve(0,0,nums);
        int ans=0;
        for(int num:sum){
            ans+=num;
        }
        return ans;
    }

    void solve(int i,int sum,int[] nums){
        if(i>=nums.length){
            this.sum.add(sum);
            return;
        }

        solve(i+1,sum^nums[i],nums);
        solve(i+1,sum,nums);
    }
}