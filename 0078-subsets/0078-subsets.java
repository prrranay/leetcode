class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        solve(new ArrayList<>(), nums, 0);
        return ans;
    }

    public void solve(List<Integer> curr, int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        solve(curr,nums,i+1);
        curr.remove(curr.size()-1);

        solve(curr,nums,i+1);
    }
}