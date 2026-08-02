class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalg=0;
        int totalc=0;
        int start=0;
        int tank=0;
        for(int i=0;i<gas.length;i++){
            totalg+=gas[i];
            totalc+=cost[i];

            tank=(tank-cost[i])+gas[i];
            
            if(tank <0){
                tank=0;
                start=i+1;
            }
        }

        if(totalc > totalg){
            return -1;
        }
        
        return start;
    }
}