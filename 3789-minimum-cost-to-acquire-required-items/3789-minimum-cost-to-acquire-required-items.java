class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minCost=Math.min(costBoth,cost1+cost2);
        int minNeed=Math.min(need1,need2);
        long ans=(long)minNeed*minCost;

        if(need1-minNeed != 0){
            ans+=(long)(need1-minNeed)*Math.min(costBoth,cost1);
        } 

        if(need2-minNeed != 0){
            ans+=(long)(need2-minNeed)*Math.min(costBoth,cost2);
        } 
        return ans;
    }
}