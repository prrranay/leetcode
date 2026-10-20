class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }

        int tank=0;
        int start=0;
        for(int i=0;i<gas.length-1;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }

        return start;
    }
}