class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // component[i] = connected component id of index i
        int[] component = new int[n];
        component[0] = 0;

        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                component[i] = component[i - 1];
            } else {
                component[i] = component[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = component[queries[i][0]] == component[queries[i][1]];
        }

        return ans;
    }
}