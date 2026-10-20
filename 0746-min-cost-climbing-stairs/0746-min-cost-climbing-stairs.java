class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first=cost[0];
        int second=cost[1];

        for(int i=2;i<cost.length;i++){
            int curr=Math.min(first,second)+cost[i];
            first=second;
            second=curr;
        }
        return Math.min(first,second);
    }
}