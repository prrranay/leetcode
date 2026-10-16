class Solution {
    public int maximumSum(int[] arr) {
        int devineEnergy=0;
        int energy=arr[0];
        int ans=arr[0];

        for(int i=1;i<arr.length;i++){
            devineEnergy=Math.max(energy,devineEnergy+arr[i]);
            energy=Math.max(arr[i],energy+arr[i]);
            ans=Math.max(ans,Math.max(energy,devineEnergy));
        }

        return ans;
    }
}