class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for(int num:arr1){
            int i=0;
            while(i<arr2.length){
                if(Math.abs(arr2[i]-num) <= d){
                    break;
                }
                i++;
            }

            if(i==arr2.length){
                ans++;
            }
        }
        return ans;
    }
}