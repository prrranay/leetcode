class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength=Arrays.stream(matchsticks).sum();
        if(totalLength %4 != 0) return false;

        int length=totalLength/4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[]sides=new int[4];
        
        return solve(matchsticks,sides,length,0);
    }

    boolean solve(int[] matchsticks,int[] side,int length,int idx){
        if(idx==matchsticks.length){
            return side[0] ==  side[1] && side[1] == side[2] && side[2] == side[3];
        }


        for(int i=0;i<4;i++){
            if(side[i]+matchsticks[idx] <= length){
                side[i]+=matchsticks[idx];
                if(solve(matchsticks,side,length,idx+1)){
                    return true;
                }
                side[i]-=matchsticks[idx];
            }
        }

        return false;
    }

    void reverse(int[] nums){
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int temp=nums[right];
            nums[right--]=nums[left];
            nums[left++]=temp;
        }
    }
}